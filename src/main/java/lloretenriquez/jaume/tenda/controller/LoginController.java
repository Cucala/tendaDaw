package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lloretenriquez.jaume.tenda.bussines.DDBB;

public class LoginController {
    @FXML
    private TextField userTextFill;
    @FXML
    private TextField passwordTextFill;

    @FXML
    protected void login(){
        System.out.print(DDBB.login(userTextFill.getText(),passwordTextFill.getText()));

    }
}
