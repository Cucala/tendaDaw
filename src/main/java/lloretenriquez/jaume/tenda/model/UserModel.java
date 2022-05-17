package lloretenriquez.jaume.tenda.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class UserModel {

    private final SimpleStringProperty userName;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty email;
    private final SimpleStringProperty password;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty phone;
    private final SimpleIntegerProperty id;

    public UserModel(ArrayList<String> datosUsuario) {
        this.id = new SimpleIntegerProperty(Integer.parseInt(datosUsuario.get(0)));
        this.userName = new SimpleStringProperty(datosUsuario.get(1));
        this.name = new SimpleStringProperty(datosUsuario.get(2));
        this.surname = new SimpleStringProperty(datosUsuario.get(3));
        this.phone = new SimpleIntegerProperty(Integer.parseInt(datosUsuario.get(4)));
        this.email = new SimpleStringProperty(datosUsuario.get(5));
        this.password = new SimpleStringProperty(datosUsuario.get(6));
    }

    @Override
    public String toString() {
        return this.id + " - " + this.userName + " - " + this.email;
    }

    public String getUserName() {
        return this.userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getSurname() {
        return this.surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return this.password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPhone() {
        return this.phone.get();
    }

    public void setPhone(int phone) {
        this.phone.set(phone);
    }

    public int getId() {
        return this.id.get();
    }

}
