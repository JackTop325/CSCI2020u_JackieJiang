module example.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens example.server to javafx.fxml;
    exports example.server;
}