module example.lab09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens example.lab09 to javafx.fxml;
    exports example.lab09;
}