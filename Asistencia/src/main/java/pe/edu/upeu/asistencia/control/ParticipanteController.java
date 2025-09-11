package pe.edu.upeu.asistencia.control;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;

    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    TableView<Participante> TableView;

    ObservableList<Participante> Participantes;
    TableColumn<Participante, String> dniCol, nombreCol, apellidoCol, carreraCol, tipoPartCol;
    TableColumn<Participante, Void> opcionCol;

    @Autowired
    ParticipanteServicioI ps;

    @FXML TextField txtDNI, txtNombre, txtApellidos;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll( Carrera.values() );
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        definirNombresColumnas();
        listarParticipantes();

    }
    public void definirNombresColumnas(){
        dniCol = new TableColumn("DNI");
        nombreCol = new TableColumn("Nombre");
        apellidoCol = new TableColumn("Apellido");
        apellidoCol.setMinWidth(180);
        carreraCol = new TableColumn("Carrera");
        tipoPartCol = new TableColumn("Tipo Participante");
        tipoPartCol.setMinWidth(160);
        opcionCol=new  TableColumn("Opcion");
        TableView.getColumns().addAll(dniCol, nombreCol, apellidoCol, carreraCol, tipoPartCol, opcionCol);
    }
    public void agregarAccionBotones(){
        Callback<TableColumn<Participante, Void>, TableCell<Participante, Void>> cellFactory =
                param-> new TableCell<>(){
                Button btEditar = new Button("Editar");
                Button btEliminar = new Button("Eliminar");
                    {
                        btEditar.setOnAction(event -> {
                            System.out.println("Editando participante");
                        });
                        btEliminar.setOnAction(event -> {
                            eliminarParticipante(getIndex());
                        });

                    }

            @Override
            protected void updateItem(Void item, boolean empty){
                        super.updateItem(item, empty);
                        if(empty){
                            setGraphic(null);
                        }else{
                            HBox hBox = new HBox(btEditar, btEliminar);
                            hBox.setSpacing(10);
                            setGraphic(hBox);
                        }
                }
                };
        opcionCol.setCellFactory(cellFactory);
    }

    public void listarParticipantes(){
        dniCol.setCellValueFactory(cellData ->
                cellData.getValue().getDni());
        nombreCol.setCellValueFactory(cellData ->
                cellData.getValue().getNombre());
        apellidoCol.setCellValueFactory(cellData ->
                cellData.getValue().getApellido());
        carreraCol.setCellValueFactory(cellData->
                new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        tipoPartCol.setCellValueFactory(cellData->
                new SimpleStringProperty(cellData.getValue().getTipoParticipante().toString()));
        agregarAccionBotones();

        Participantes= FXCollections.observableArrayList(ps.findAll());
        TableView.setItems(Participantes);
    }

    @FXML
    public void crearParticipante(){
        Participante participante = new Participante();
        participante.setDni(new SimpleStringProperty(txtDNI.getText()));
        participante.setNombre(new SimpleStringProperty(txtNombre.getText()));
        participante.setApellido(new SimpleStringProperty(txtApellidos.getText()));
        participante.setCarrera(cbxCarrera.getValue());
        participante.setTipoParticipante(cbxTipoParticipante.getValue());
        ps.save(participante);
        listarParticipantes();
    }
    public void eliminarParticipante(int index){
        ps.delete(index);
        listarParticipantes();
    }

}
