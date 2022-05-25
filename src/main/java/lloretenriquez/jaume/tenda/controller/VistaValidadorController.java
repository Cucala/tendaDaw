package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lloretenriquez.jaume.tenda.bussines.DDBB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.IOException;

public class VistaValidadorController {

    private int id;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordConfirmField;

    public void setId(int id){
        this.id = id;
    }

    @FXML
    protected void guardar() throws IOException {
        if (comprobarPassword()) {
            String contrasenyaEncriptada = convertirSHA256(passwordField.getText());
            DDBB.actualizarContrasenyaUsuarios(contrasenyaEncriptada, id);
        }
    }

    private boolean comprobarPassword(){

        if(passwordField.getText().compareTo(passwordConfirmField.getText()) == 0){
            return true;
        }
        return false;
    }

    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
