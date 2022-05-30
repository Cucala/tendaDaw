package lloretenriquez.jaume.tenda.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProveedorModel {
    private  final SimpleStringProperty name;
    private  final SimpleStringProperty categoria;
    private final SimpleIntegerProperty id;

    public ProveedorModel(String name, String categoria, int id) {
        this.name =  new SimpleStringProperty(name);
        this.categoria = new SimpleStringProperty(categoria);
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getCategoria() {
        return categoria.get();
    }

    public SimpleStringProperty categoriaProperty() {
        return categoria;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }
}
