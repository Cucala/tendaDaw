package lloretenriquez.jaume.tenda.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TpvController {
    @FXML
    private VBox selectionArea;

    private ArrayList<ArrayList<String>> products;

    protected void fetchButtons(){
        selectionArea.getChildren().removeAll();
        addHBox();
        HBox currentHBox = ((HBox) selectionArea.getChildren().get(0));
        int hboxAdded = 0;

        for(int i = 0; i < products.size(); i++){
            if(i % 3 == 0){
                addHBox();
                currentHBox = ((HBox) selectionArea.getChildren().get(hboxAdded));
                hboxAdded++;
            }
            Button btnAux = new Button("btn" + i);
            currentHBox.getChildren().add(btnAux);
        }
    }



    private void addHBox(){
        selectionArea.getChildren().add(new HBox());
    }






}
