module org.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires fontawesomefx;

    opens org.example.proyecto to javafx.fxml;
    opens org.example.proyecto.models to javafx.base;

    exports org.example.proyecto;
}