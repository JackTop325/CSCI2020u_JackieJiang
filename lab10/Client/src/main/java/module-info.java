module example.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.client to javafx.fxml;
    exports example.client;
}