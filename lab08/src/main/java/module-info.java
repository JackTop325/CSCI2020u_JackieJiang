module example.lab08 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.lab08 to javafx.fxml;
    exports example.lab08;
}