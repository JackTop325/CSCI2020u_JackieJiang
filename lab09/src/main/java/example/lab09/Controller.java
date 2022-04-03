package example.lab09;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private void drawLinePlot(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(50, 500, 800, 500);
        gc.strokeLine(50, 50, 50, 500);
    }

    private ArrayList<Double> downloadStockPrices(String address) throws FileNotFoundException, MalformedURLException {
        ArrayList<Double> closePrices = new ArrayList<Double>();
        try{
            URL url = new URL(address);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String ln;
            ln = in.readLine();
            //System.out.println(ln);
            while(null !=(ln = in.readLine())) {
                String[] row = ln.split(",");
                //System.out.println(Arrays.toString(row));
                closePrices.add(Double.valueOf(row[4]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return closePrices;
    }

    private void drawLine(GraphicsContext gc, ArrayList<Double> company, Color colour){
        gc.setStroke(colour);
        gc.setLineWidth(1);
        double currY,nextY;
        nextY = company.get(0);
        for (int i = 1; i < company.size()-1;i++){
            currY = company.get(i);
            gc.strokeLine(((i*10)+50),500 - nextY/2,((i*10)+60), 500 - currY/2);
            nextY = company.get(i);
        }
    }

    @FXML
    private Canvas board;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        GraphicsContext gc = board.getGraphicsContext2D();
        drawLinePlot (gc);
        try {
            ArrayList<Double> google = downloadStockPrices("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
            ArrayList<Double> apple = downloadStockPrices("https://query1.finance.yahoo.com/v7/finance/download/AAPL?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
            drawLine(gc, google, Color.BLUE);
            drawLine(gc, apple, Color.RED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }
}