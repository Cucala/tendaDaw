package lloretenriquez.jaume.tenda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lloretenriquez.jaume.tenda.bussines.DDBB;
import lloretenriquez.jaume.tenda.model.UserModel;

import java.sql.*;
import java.util.ArrayList;

public class VistaUsuarioController{
    private ObservableList<UserModel> diccionarioUsuarios;

    private int id;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField lastTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TableView tablaUsuarios;

    public void setId(int id) {
        this.id = id;
    }

    public void initialize(){
        mostrarDatos();
    }

    protected void selectElement() {
        UserModel selectedItem = (UserModel) tablaUsuarios.getSelectionModel().getSelectedItem();
        usernameTextField.setText(selectedItem.getUserName());
        nameTextField.setText(selectedItem.getName());
        lastTextField.setText(selectedItem.getSurname());
        emailTextField.setText(selectedItem.getEmail());
        phoneTextField.setText(Integer.toString(selectedItem.getPhone()));
    }

    @FXML
    protected void clean() {
        tablaUsuarios.getSelectionModel().clearSelection();
        usernameTextField.clear();
        nameTextField.clear();
        lastTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();
    }

    @FXML
    protected void saveNewUser(){
        if(!usernameTextField.getText().equals("") && !nameTextField.getText().equals("")
                && !lastTextField.getText().equals("") && !phoneTextField.getText().equals("")
                && !emailTextField.getText().equals("")){
            if (tablaUsuarios.getSelectionModel().getSelectedItem() != null) {
                DDBB.actualizar(usernameTextField.getText() ,nameTextField.getText(), lastTextField.getText(),
                        phoneTextField.getText(), emailTextField.getText(),
                        ((UserModel)tablaUsuarios.getSelectionModel().getSelectedItem()).getId());
            }
            else {
                DDBB.insertar(usernameTextField.getText() ,nameTextField.getText(), lastTextField.getText(),
                        phoneTextField.getText(), emailTextField.getText());
            }
            mostrarDatos();
        }

        else{
            System.out.println("Nope");
        }
    }

    @FXML
    protected void deleteUser(){
        if (tablaUsuarios.getSelectionModel().getSelectedItem() != null) {
                DDBB.delete(
                        ((UserModel)tablaUsuarios.getSelectionModel().getSelectedItem()).getId());
        }
        else {
            System.out.println("Nope");
        }
        mostrarDatos();
        clean();

    }



    public void mostrarDatos(){
        ArrayList<ArrayList<String>> datos = DDBB.mostrarVistaUsuarios();

        tablaUsuarios.getColumns().clear();
        TableColumn idUsuario = new TableColumn("ID");
        TableColumn nombreUsuario = new TableColumn("NOMBRE");
        TableColumn emailUsuario = new TableColumn("E-EMAIL");

        diccionarioUsuarios = FXCollections.observableArrayList();

        for(ArrayList<String> datosUsuario : datos) {
            diccionarioUsuarios.add(new UserModel(datosUsuario));
        }

        idUsuario.setCellValueFactory(
                new PropertyValueFactory<UserModel,Integer>("id")
        );

        nombreUsuario.setCellValueFactory(
                new PropertyValueFactory<UserModel,String>("userName")
        );

        emailUsuario.setCellValueFactory(
                new PropertyValueFactory<UserModel,String>("email")
        );


        tablaUsuarios.setItems(diccionarioUsuarios);
        tablaUsuarios.getColumns().addAll(idUsuario, nombreUsuario, emailUsuario);

        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((lista,anterior,nueva) -> {
            if(nueva != null){
                selectElement();
            }
        });
    }
}
