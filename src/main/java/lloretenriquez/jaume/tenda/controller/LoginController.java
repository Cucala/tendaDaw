package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lloretenriquez.jaume.tenda.HelloApplication;
import lloretenriquez.jaume.tenda.bussines.DDBB;

import java.io.IOException;

public class LoginController {

    private int id;

    @FXML
    private TextField userTextFill;
    @FXML
    private TextField passwordTextFill;

    @FXML
    protected void login() throws IOException {
        id = DDBB.login(userTextFill.getText(),passwordTextFill.getText());

        if(id != 0){
            if(!DDBB.isValidated(DDBB.login(userTextFill.getText(),passwordTextFill.getText()))){
                changeToValidatorPSWDView();
            }
            changeToUsuarioView();
        }
    }

    @FXML
    private void changeToValidatorPSWDView() throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("validador-contrasena.fxml"));
        // Paso 2
        VistaValidadorController controller = new VistaValidadorController();
        controller.setId(id);
        // Paso 3
        loader.setController(controller);
        // Paso 4
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HelloApplication.window.setTitle("Rostidor De Javi");
        HelloApplication.window.setScene(scene);
        HelloApplication.window.show();
    }

    @FXML
    private void changeToUsuarioView() throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("mainView-view.fxml"));

        // Paso 2
        MainViewController controller = new MainViewController();
        // Paso 3
        loader.setController(controller);
        // Paso 4
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HelloApplication.window.setTitle("Rostidor De Javi - Main View");
        HelloApplication.window.setScene(scene);
        HelloApplication.window.show();

    }

}
