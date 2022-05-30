package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lloretenriquez.jaume.tenda.HelloApplication;

import java.io.IOException;

public class MainViewController {
    private FXMLLoader loader;

    @FXML
    protected void goToUsersView() throws IOException {
        goToView("vista-usuario.fxml", "User Title");
    }

    @FXML
    protected void goToTpvView() throws IOException {
        goToView("tpv-view.fxml", "TPV Title");


    }

    private void goToView(String view, String title) throws IOException {
        loader = new FXMLLoader(HelloApplication.class.getResource(view));
        addController();

        Parent root = loader.load();
        Scene scene = new Scene(root);
        HelloApplication.window.setTitle(title);
        HelloApplication.window.setScene(scene);
        HelloApplication.window.show();
    }

    private void addController() {
        String file = loader.getLocation().getFile().split("/")[loader.getLocation().getFile().split("/").length-1];

        if (file.compareTo("vista-usuario.fxml") == 0) {

          loader.setController(new VistaUsuarioController());
        }
        if (file.compareTo("tpv-view.fxml") == 0) {

            loader.setController(new TpvController());
        }

    }

}
