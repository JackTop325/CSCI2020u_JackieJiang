package example.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.*;
import java.net.*;
import java.util.*;

public class HelloController implements Initializable {
    private String address = "localhost";
    private int port = 6666;

    private DataOutputStream dout = null;
    private Socket sock = null;

    @FXML
    private TextField username;
    @FXML
    private TextField message;

    @FXML
    protected void send() {
        try {
            dout.writeUTF(username.getText()+": "+message.getText());
        }
        catch(IOException e){
            System.out.println(e);
        }
        username.clear();
        message.clear();
    }
    @FXML
    protected void exit() {
        try {
            dout.close();
            sock.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        System.out.println("Connection terminated...");
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            sock = new Socket (address, port);
            System.out.println("Connected to server...");
            //open output stream on socket
            dout = new DataOutputStream(sock.getOutputStream());
        } catch(IOException e){
            System.out.println(e);
        }
    }
}