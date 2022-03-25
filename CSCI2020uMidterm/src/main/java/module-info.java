module example.csci2020umidterm {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.csci2020umidterm to javafx.fxml;
    exports example.csci2020umidterm;
}