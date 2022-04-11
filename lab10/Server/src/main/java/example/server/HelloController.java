package example.server;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.*;
import java.net.*;

public class HelloController implements Initializable{
    private Server server;

    @FXML
    public TextArea textBox;

    @FXML
    protected void exit() throws IOException {
        server.quit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        server = new Server(6666,textBox);
        Thread handlerThread = new Thread(server, "Handler Thread");
        handlerThread.start();
    }
}