package lk.ijse.chicagosystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.util.DateAndTime;
import lk.ijse.chicagosystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class StoreKeeperController implements Initializable {

    public JFXButton btnOrder;
    public JFXButton btnManageCustomer;
    public Label lblDate;
    public Text txtHour;
    public ImageView imgView;
    public AnchorPane viewInventoryPane;
    public AnchorPane orderViewPane;
    public NumberAxis barChart;


    final static String Keeri = "Keeri";
    final static String Basmathi = "Basmathi";
    final static String Vegitables = "Vegitables";
    final static String Spices = "Spices";
    final static String Packing_Meterials = "Packing_Meterials";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(DateAndTime.dateNow());
        setTime();



       
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number,String> barChart =
                new BarChart<Number,String>(xAxis,yAxis);
        barChart.setTitle("Inventory Summary");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Available");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Foods");
        series1.getData().add(new XYChart.Data(25601.34, Keeri));
        series1.getData().add(new XYChart.Data(20148.82, Basmathi));
        series1.getData().add(new XYChart.Data(10000, Vegitables));
        series1.getData().add(new XYChart.Data(35407.15, Spices));
        series1.getData().add(new XYChart.Data(12000, Packing_Meterials));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Foods");
        series2.getData().add(new XYChart.Data(57401.85, Keeri));
        series2.getData().add(new XYChart.Data(41941.19, Basmathi));
        series2.getData().add(new XYChart.Data(45263.37, Vegitables));
        series2.getData().add(new XYChart.Data(117320.16, Spices));
        series2.getData().add(new XYChart.Data(14845.27, Packing_Meterials));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Foods");
        series3.getData().add(new XYChart.Data(45000.65, Keeri));
        series3.getData().add(new XYChart.Data(44835.76, Basmathi));
        series3.getData().add(new XYChart.Data(18722.18, Vegitables));
        series3.getData().add(new XYChart.Data(17557.31, Spices));
        series3.getData().add(new XYChart.Data(92633.68, Packing_Meterials));

         barChart.setUserData("series1, series2, series3");
 

    }


    public void viewMenuOnAction(ActionEvent actionEvent) {
        orderViewPane.setVisible(true);
        viewInventoryPane.setVisible(false);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.swichNavigation("LoginForm.fxml", actionEvent);
    }
    //set Time
    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtHour.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }

    public void inventoryOnAction(ActionEvent actionEvent) {
        orderViewPane.setVisible(false);
        viewInventoryPane.setVisible(true);
    }
}
