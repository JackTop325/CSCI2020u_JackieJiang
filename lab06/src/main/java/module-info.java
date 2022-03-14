module example.lab06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens example.lab06 to javafx.fxml;
    exports example.lab06;
}