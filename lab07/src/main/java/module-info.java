module example.lab07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.lab07 to javafx.fxml;
    exports example.lab07;
}