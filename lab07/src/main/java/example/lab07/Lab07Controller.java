package example.lab07;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Lab07Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}