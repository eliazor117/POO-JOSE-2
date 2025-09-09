package pe.edu.upeu.asistencia.control;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @Autowired
    ParticipanteServicioI ps;

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
        apellidoCol.setMinWidth(200);
        carreraCol = new TableColumn("Carrera");
        tipoPartCol = new TableColumn("Tipo Participante");
        tipoPartCol.setMinWidth(160);
        TableView.getColumns().addAll(dniCol, nombreCol, apellidoCol, carreraCol, tipoPartCol);
    }
    public void listarParticipantes(){
        dniCol.setCellValueFactory(cellData ->
                cellData.getValue().getDni());
        Participantes= FXCollections.observableArrayList(ps.findAll());
        TableView.setItems(Participantes);
    }

}
