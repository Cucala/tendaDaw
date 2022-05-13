package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lloretenriquez.jaume.tenda.bussines.DDBB;
import lloretenriquez.jaume.tenda.model.UserModel;

import java.sql.*;
import java.util.ArrayList;

public class VistaUsuarioController {
    private ArrayList<UserModel> diccionarioUsuarios = new ArrayList<>();
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField lastTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private ListView listaUsuarios;
    @FXML
    protected void clean() {
        nameTextField.clear();
        lastTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();

        mostrarDatos();
    }

    public void mostrarDatos(){
        ArrayList<ArrayList<String>> datos = DDBB.mostrarVistaUsuarios();

        for(ArrayList<String> datosUsuario : datos) {
            UserModel usuario = new UserModel(datosUsuario);
            listaUsuarios.getItems().add(usuario);
        }
    }
}
