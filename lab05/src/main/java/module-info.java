module example.lab05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.lab05 to javafx.fxml;
    exports example.lab05;
}