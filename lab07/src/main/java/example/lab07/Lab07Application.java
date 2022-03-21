package example.lab07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Lab07Application extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        HashMap<String,Integer> weatherCount = new HashMap<>();

        FileReader read = new FileReader("weatherwarnings-2015.csv");
        BufferedReader in = new BufferedReader(read);
        String ln;
        while((ln = in.readLine()) != null) {
            if (ln.trim().length() != 0) {
                String[] data = ln.split(",");
                if(!weatherCount.containsKey(data[5])){
                    weatherCount.put(data[5],1);
                }else{
                    int count = weatherCount.get(data[5]);
                    weatherCount.put(data[5], count+1);
                }
            }
        }
        //System.out.println(weatherCount);
        int n = weatherCount.size();
        String[] weatherType = new String [n];
        int [] typeCount = new int [n];
        int i = 0;
        for ( HashMap.Entry<String, Integer> entry : weatherCount.entrySet()) {
            weatherType[i] = entry.getKey();
            typeCount[i] = entry.getValue();
            i += 1;
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data(weatherType[0], typeCount[0]),
            new PieChart.Data(weatherType[1], typeCount[1]),
            new PieChart.Data(weatherType[2], typeCount[2]),
            new PieChart.Data(weatherType[3], typeCount[3]));


        final PieChart pie = new PieChart(pieChartData);
        pie.setTitle("Weather Warnings 2015");
        primaryStage.setTitle("Lab 07");
        primaryStage.setScene(new Scene(pie, 500, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}