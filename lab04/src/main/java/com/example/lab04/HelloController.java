package com.example.lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private TextField FullName;
    @FXML
    private TextField E_mail;
    @FXML
    private TextField Phone;
    @FXML
    private DatePicker DoB;

    @FXML
    protected void RegisterButton() {
        System.out.println(Username.getText());
        System.out.println(Password.getText());
        System.out.println(FullName.getText());
        System.out.println(E_mail.getText());
        System.out.println(Phone.getText());
        System.out.println(DoB.getValue());
        Username.clear();
        Password.clear();
        FullName.clear();
        E_mail.clear();
        Phone.clear();
        DoB.setValue(null);

    }
}