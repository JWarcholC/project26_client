package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class AudienceBarChart {
    final static String aName = "A";
    final static String bName = "B";
    final static String cName = "C";
    final static String dName = "D";


    public void display(LinkedList<Integer> percent) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0,100,10);
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Audience Help");
        yAxis.setLabel("Percent");

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(aName, percent.get(0))); // a
        series1.getData().add(new XYChart.Data(bName, percent.get(1))); // b
        series1.getData().add(new XYChart.Data(cName, percent.get(2))); // c
        series1.getData().add(new XYChart.Data(dName, percent.get(3))); // d


        try {
            Parent frame = FXMLLoader.load(getClass().getResource("Chart.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene  = new Scene(bc,600,480);
        bc.getData().add(series1);
        stage.setScene(scene);
        stage.show();
    }
}
