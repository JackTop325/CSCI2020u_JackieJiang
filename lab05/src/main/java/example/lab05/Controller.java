package example.lab05;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<StudentRecord> tableView;
    @FXML
    private final TableColumn<StudentRecord,String> studentID = new TableColumn<>("studentID");
    @FXML
    private final TableColumn<StudentRecord,Float> midterm = new TableColumn<>("midterm");
    @FXML
    private final TableColumn<StudentRecord,Float> assignments = new TableColumn<>("assignments");
    @FXML
    private final TableColumn<StudentRecord,Float> finalExam = new TableColumn<>("finalExam");
    @FXML
    private final TableColumn<StudentRecord,Float> finalMark = new TableColumn<>("finalMark");
    @FXML
    private final TableColumn<StudentRecord,String> letterGrade = new TableColumn<>("letterGrade");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(DataSource.getAllMarks());
    }
}
