package lloretenriquez.jaume.tenda.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lloretenriquez.jaume.tenda.HelloApplication;
import lloretenriquez.jaume.tenda.bussines.DDBB;

import java.util.ArrayList;

public class TpvController extends Controller{
    @FXML
    private VBox selectionArea;

    @FXML
    private ListView ticket;

    private ArrayList<ArrayList<String>> products;

    public void initialize(){
        products = DDBB.getProducts();
        fetchButtons();
    }
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

            Image img = new Image("http://www.maestrosdelweb.com/images/2009/08/crayones_jpg.jpg");
            //Image img = new Image("http://cdn-3.expansion.mx/dims4/default/a4dc17e/2147483647/strip/true/crop/2096x1430+0+0/resize/1200x819!/format/webp/quality/90/?url=https%3A%2F%2Fcdn-3.expansion.mx%2F95%2F6c%2F722abfb544dcb4a46b9ca967a1ef%2Fistock-499925476.jpg");
            System.out.println(products.get(i).get(3));
            ImageView imgView = new ImageView(img);

            imgView.setFitHeight(80.d);
            imgView.setFitWidth(80.d);
            Button btn = new Button();
            btn.setGraphic(imgView);
            btn.setPrefSize(80, 80);
            btn.setMaxHeight(80);
            btn.setMaxWidth(80);
            btn.setId(products.get(i).get(0));
            /*btn.setOnAction(event -> {
                ticket.getItems().forEach((String txt) -> {
                    //if(txt.compareTo() == 0)
                });

            });*/
            currentHBox.getChildren().add(btn);
        }
    }



    private void addHBox(){
        selectionArea.getChildren().add(new HBox());
    }






}
