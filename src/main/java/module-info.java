module lloretenriquez.jaume.tenda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens lloretenriquez.jaume.tenda to javafx.fxml;
    exports lloretenriquez.jaume.tenda;
    exports lloretenriquez.jaume.tenda.controller;
    opens lloretenriquez.jaume.tenda.controller to javafx.fxml;
    opens lloretenriquez.jaume.tenda.model to javafx.base;
    exports lloretenriquez.jaume.tenda.model;
}