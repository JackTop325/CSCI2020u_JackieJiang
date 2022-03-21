package example.lab06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class Lab06Application extends Application {

    //Data for Bar Chart
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    //Data for Pie Chart
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab06");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
        barChart.setTitle("Bar Chart");
        xAxis.setLabel("Housing vs Commercial");
        yAxis.setLabel("Price");

        XYChart.Series chart1 = new XYChart.Series();
        chart1.setName("Housing");
        chart1.getData().add(new XYChart.Data("2015", avgHousingPricesByYear[0]));
        chart1.getData().add(new XYChart.Data("2016", avgHousingPricesByYear[1]));
        chart1.getData().add(new XYChart.Data("2017", avgHousingPricesByYear[2]));
        chart1.getData().add(new XYChart.Data("2018", avgHousingPricesByYear[3]));
        chart1.getData().add(new XYChart.Data("2019", avgHousingPricesByYear[4]));
        chart1.getData().add(new XYChart.Data("2020", avgHousingPricesByYear[5]));
        chart1.getData().add(new XYChart.Data("2021", avgHousingPricesByYear[6]));
        chart1.getData().add(new XYChart.Data("2022", avgHousingPricesByYear[7]));

        XYChart.Series chart2 = new XYChart.Series();
        chart2.setName("Commercial");
        chart2.getData().add(new XYChart.Data("2015", avgCommercialPricesByYear[0]));
        chart2.getData().add(new XYChart.Data("2016", avgCommercialPricesByYear[1]));
        chart2.getData().add(new XYChart.Data("2017", avgCommercialPricesByYear[2]));
        chart2.getData().add(new XYChart.Data("2018", avgCommercialPricesByYear[3]));
        chart2.getData().add(new XYChart.Data("2019", avgCommercialPricesByYear[4]));
        chart2.getData().add(new XYChart.Data("2020", avgCommercialPricesByYear[5]));
        chart2.getData().add(new XYChart.Data("2021", avgCommercialPricesByYear[6]));
        chart2.getData().add(new XYChart.Data("2022", avgCommercialPricesByYear[7]));

        barChart.getData().addAll(chart1,chart2);


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]),
                new PieChart.Data(ageGroups[5], purchasesByAgeGroup[5]));

        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Pie Chart");


        FlowPane root = new FlowPane();
        root.getChildren().addAll(barChart,pieChart);

        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}