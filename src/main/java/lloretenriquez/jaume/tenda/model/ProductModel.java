package lloretenriquez.jaume.tenda.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class ProductModel {
    private final SimpleIntegerProperty id;

    private final SimpleStringProperty name;

    private final SimpleIntegerProperty price;

    private int quantity;

    public ProductModel(ArrayList<String> products) {
        this.id = new SimpleIntegerProperty(Integer.parseInt(products.get(0)));
        this.name = new SimpleStringProperty((products.get(1)));
        this.price = new SimpleIntegerProperty(Integer.parseInt(products.get(4)));
        this.quantity = 0;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int increment){
        this.quantity += increment;
    }


}
