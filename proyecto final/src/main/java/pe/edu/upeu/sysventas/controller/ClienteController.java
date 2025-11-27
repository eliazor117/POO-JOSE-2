package pe.edu.upeu.sysventas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDni;
    @FXML private TextField txtTelefono;
    @FXML private TableView<?> tableClientes;

    @FXML
    public void initialize() {
        // Inicialización simple. Añade aquí la carga de clientes si tienes DAO.
        System.out.println("ClienteController inicializado");
    }

    @FXML
    public void onGuardarCliente() {
        // Guardado simple para pruebas
        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String tel = txtTelefono.getText();
        System.out.println("Guardar cliente: " + nombre + " - " + dni + " - " + tel);
        // Aquí llamas a tu dao para guardar en BD
    }

    @FXML
    public void onCancelar() {
        txtNombre.clear();
        txtDni.clear();
        txtTelefono.clear();
    }
}
