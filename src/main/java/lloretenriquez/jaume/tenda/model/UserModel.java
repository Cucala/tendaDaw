package lloretenriquez.jaume.tenda.model;

import java.util.ArrayList;

public class UserModel {
    private String userName, surname, email, password, name;
    private  int phone, id;

    public UserModel(ArrayList<String> datosUsuario) {
        this.id = Integer.parseInt(datosUsuario.get(0));
        this.userName = datosUsuario.get(1);
        this.name = datosUsuario.get(2);
        this.surname = datosUsuario.get(3);
        this.phone = Integer.parseInt(datosUsuario.get(4));
        this.email = datosUsuario.get(5);
        this.password = datosUsuario.get(6);
    }

    @Override
    public String toString() {
        return this.id + " - " + this.userName + " - " + this.email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

}
