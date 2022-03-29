package example.lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField FinalExam;
    @FXML
    private TextField Midterm;
    @FXML
    private TextField Assignments;
    @FXML
    private TextField SID;
    @FXML
    private TableView<StudentRecord> tableView;

    public String currentFilename = "main.csv";
    ObservableList<StudentRecord> marks = FXCollections.observableArrayList();
    @FXML
    private void clear(){
        currentFilename = "";
        tableView.getItems().clear();
    }
    @FXML
    private MenuItem fileOpen;

    @FXML
    protected void add() {
        marks.add(new StudentRecord(SID.getText(), Float.parseFloat(Midterm.getText()),
            Float.parseFloat(Assignments.getText()), Float.parseFloat(FinalExam.getText())));
        SID.clear();
        Assignments.clear();
        Midterm.clear();
        FinalExam.clear();
        tableView.setItems(marks);
    }
    @FXML
    protected void save() throws IOException {
        if (currentFilename.equals("")){
            saveAs();
        }else {
            FileWriter writer = new FileWriter(currentFilename);
            for (StudentRecord mark : marks) {
                //System.out.println(mark);
                writer.write(mark + System.lineSeparator());
            }
            writer.close();
        }
    }
    @FXML
    protected void saveAs() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV", "*.csv"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showSaveDialog(fileOpen.getParentPopup().getScene().getWindow());
        FileWriter writer = new FileWriter(selectedFile);
        for(StudentRecord mark:marks){
            //System.out.println(mark);
            writer.write(mark + System.lineSeparator());
        }
        writer.close();
    }
    @FXML
    public void open () throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV", "*.csv"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(fileOpen.getParentPopup().getScene().getWindow());
        //System.out.println(selectedFile);
        tableView.setItems(getMarks(selectedFile));
    }
    public ObservableList<StudentRecord> getMarks(File fileName) throws FileNotFoundException {
        marks = FXCollections.observableArrayList();

        FileReader read = new FileReader(fileName);
        BufferedReader in = new BufferedReader(read);
        String ln;
        try{
            while(null !=(ln = in.readLine())) {
                String[] row = ln.split(",");
                // Student ID, Assignments, Midterm, Final exam
                marks.add(new StudentRecord(row[0], Float.parseFloat(row[1]), Float.parseFloat(row[1]),
                    Float.parseFloat(row[1])));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return marks;
    }

    @FXML
    private void close(){
        System.exit(0);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(DataSource.getAllMarks());
        marks = DataSource.getAllMarks();
    }
}