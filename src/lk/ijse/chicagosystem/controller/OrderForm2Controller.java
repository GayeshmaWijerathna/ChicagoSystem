package lk.ijse.chicagosystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.db.DBConnection;
import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.model.CustomerModel;
import lk.ijse.chicagosystem.model.MenuModel;
import lk.ijse.chicagosystem.model.OrderModel;
import lk.ijse.chicagosystem.to.Customer;
import lk.ijse.chicagosystem.to.Orders;
import lk.ijse.chicagosystem.util.DateAndTime;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class OrderForm2Controller implements Initializable {

    public HBox hBox;
    public HBox hBox2;
    public HBox hBox3;
    public HBox hBox4;
    public Text txtNoOfCart;
    public AnchorPane menuPane;
    public Text orderId;
    public JFXButton btnAdd;
    public JFXTextField lblQty;
    public Text txtTotal;
    public Text txtItemID;
    public static OrderForm2Controller instants;
    public JFXComboBox comboId;
    public Text txtCusName;
    public JFXComboBox comboOrderTye;
    public TextField txtContactnumber;
    public Pane menuCardPane;
    public JFXButton newCustomer;
    ArrayList<String> cusIds = new ArrayList<>();


    private static OrderForm2Controller qtyFocus;

    public OrderForm2Controller() {
        instants = this;
        qtyFocus = this;
    }

    // QTY Focus
    public static OrderForm2Controller getQtyFocus() {
        return qtyFocus;
    }

    public void goToPlaceorderOnAction(MouseEvent mouseEvent) {
        txtNoOfCart.setText("");
    }

//    Place Order Action
    public void proceedOnAction(ActionEvent actionEvent) throws InterruptedException {
        btnAdd.setText("NEW");
        btnAdd.setStyle("-fx-border-color: #0AFA03");
        String id = orderId.getText();
        try {
            if (OrderModel.placeOrder(
                    new Orders(orderId.getText(),
                            txtCusName.getText(),
                            DateAndTime.dateNow(),
                            DateAndTime.timeNow(),
                            txtTotal.getText(),
                            String.valueOf(comboOrderTye.getValue()),
                            String.valueOf(comboId.getValue())

                    ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Succeeded. DataBase Updated !").show();
                Db.orderDetails.clear();
                getItemsRiceCategory("Rice");
                getItemsKottuCategory("Kottu");
                getItemsBiteCategory("Bite");
                getItemsFastFoodCategory("FastFood");

                txtTotal.setText("00.00");
                txtCusName.setText("Name");
                txtItemID.setText("");
                comboOrderTye.setValue("Select Order type");
                comboId.setValue("Select Customer Id");
                lblQty.setText("");
                txtNoOfCart.setText("0");
                txtContactnumber.clear();

                InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/chicagosystem/view/reports/Bill.jrxml");

                HashMap<String, Object> hm = new HashMap<>();
//                System.out.println(id);
                hm.put("custId", id);

                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(resource);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
                    //                  JasperPrintManager.printReport(jasperPrint,true);
                    JasperViewer.viewReport(jasperPrint, false);

                } catch (JRException | SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        CashierFormController.getFeedback().feedbackPane.setVisible(true);
//        CashierFormController.getFeedback().fb;;
        CashierFormController.getFeedback().btnskipButton.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getItemsRiceCategory("Rice");
        getItemsKottuCategory("Kottu");
        getItemsBiteCategory("Bite");
        getItemsFastFoodCategory("FastFood");
        btnAdd.setText("NEW");
        btnAdd.setStyle("-fx-border-color: #0AFA03");
        customerIdsLoad();
        setOrdeType();
    }

    private void setOrdeType() {
        String[] type = {"TAKEAWAY", "DINING"};
        comboOrderTye.getItems().addAll(type);
    }

    private void customerIdsLoad() {
        try {
            ResultSet set = CustomerModel.getIds();
            while (set.next()) {
                cusIds.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboId.getItems().addAll(cusIds);
    }

    private void getItemsFastFoodCategory(String fastFood) {
        hBox4.getChildren().clear();
        try {
            ResultSet set = MenuModel.getItems(fastFood);
            while (set.next()) {
                fastFoodNavigtion(set.getString(1), set.getString(2), set.getString(3));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getItemsBiteCategory(String bite) {
        hBox3.getChildren().clear();
        try {
            ResultSet set = MenuModel.getItems(bite);
            while (set.next()) {
                biteNavigtion(set.getString(1), set.getString(2), set.getString(3));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void getItemsKottuCategory(String kottu) {
        hBox2.getChildren().clear();
        try {
            ResultSet set = MenuModel.getItems(kottu);
            while (set.next()) {
                kottuNavigtion(set.getString(1), set.getString(2), set.getString(3));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getItemsRiceCategory(String category) {
        hBox.getChildren().clear();
        try {
            ResultSet set = MenuModel.getItems(category);
            while (set.next()) {
                riceNavigtion(set.getString(1), set.getString(2), set.getString(3));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//    Navigations
    private void riceNavigtion(String id, String itemName, String price) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/chicagosystem/view/RiceBar.fxml"));
            Parent root = loader.load();
            RiceBarController controller = loader.getController();
            controller.setData(id, itemName, price);
            hBox.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void kottuNavigtion(String id, String itemName, String price) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/chicagosystem/view/KottuBar.fxml"));
            Parent root = loader.load();
            KottuBarController controller = loader.getController();
            controller.setData(id, itemName, price);
            hBox2.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void biteNavigtion(String id, String itemName, String price) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/chicagosystem/view/BiteBar.fxml"));
            Parent root = loader.load();
            BiteBarController controller = loader.getController();
            controller.setData(id, itemName, price);
            hBox3.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fastFoodNavigtion(String id, String itemName, String price) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/chicagosystem/view/FastFoodBar.fxml"));
            Parent root = loader.load();
            FastFoodBarController controller = loader.getController();
            controller.setData(id, itemName, price);
            hBox4.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Add Button
    public void addOnAction(ActionEvent actionEvent) {
        if (btnAdd.getText().equals("NEW")) {
            nextId();
            btnAdd.setText("ADD");
            btnAdd.setStyle("-fx-border-color: #c50e14");
            btnAdd.setStyle("-fx-background-color: #4374E4");
//
            RiceBarController.getDisSelection().rBtnRice.setSelected(false);
            KottuBarController.getDisSelection().rBtnKottu.setSelected(false);
            BiteBarController.getDisSelection().rBtnBites.setSelected(false);
            FastFoodBarController.getDisSelection().rBtnFastFood.setSelected(false);

        } else if (btnAdd.getText().equals("ADD")) {
            for (int i = 0; i < Db.orderDetails.size(); i++) {
                if (Db.orderDetails.get(i).getItemId().equals(txtItemID.getText())) {
                    Db.orderDetails.get(i).setQty(lblQty.getText());
                    lblQty.setText("");
                    txtItemID.setText("SELECT NEW ITEM");
                    setTotal();
                }
            }
            setCount();
        }
        setCount();
        lblQty.setText("");

    }

    //     set Count on Cart
    private void setCount() {
        txtNoOfCart.setText(String.valueOf(Db.orderDetails.size()));
    }

    //get Total
    private void setTotal() {
        double total = 0;
        for (int i = 0; i < Db.orderDetails.size(); i++) {
            total += Double.parseDouble(Db.orderDetails.get(i).getPrice()) * Double.parseDouble(Db.orderDetails.get(i).getQty());
            txtTotal.setText(String.valueOf(total));
        }
    }

    //Next Id Generator
    private void nextId() {
        try {
            ResultSet set = OrderModel.getLastId();
            String id = null;
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] o = id.split("O0");
                if (o.length >= 2) {
                    int nextId = Integer.parseInt(o[1]);
                    nextId++;
                    orderId.setText("O0" + nextId);
                } else {
                    orderId.setText("O01");
                }
            } catch (NullPointerException e) {
                orderId.setText("O01");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //    Search Customer
    public void idOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = CustomerModel.getNameForId(String.valueOf(comboId.getValue()));
            if (set.next()) {
                txtCusName.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //    Search Customer
    public void searchOnAction(ActionEvent actionEvent) {

        String id = txtContactnumber.getText();
        try {
            Customer customer = CustomerModel.search2(id);
            if (customer != null) {
                fillData(customer);
            } else {
                newCustomer.setVisible(true);
                new Alert(Alert.AlertType.INFORMATION, "No Contact in our DB").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //    Search Supportive
    public void fillData(Customer customer) {
        comboId.setValue(customer.getCusId());
        txtCusName.setText(customer.getName());

    }

    //    Menu Card Close Button
    public void closeOnAction(ActionEvent actionEvent) {
        menuCardPane.setVisible(false);
    }

    //    Menu Card View
    public void menuViewOnAction(ActionEvent actionEvent) {
        menuCardPane.setVisible(true);
    }

    //    Enter button to Add Cart
    public void qtyOnAction(ActionEvent actionEvent) {
        btnAdd.fire();
    }

    //    Add New Customer Option
    public void addNewCustomer(ActionEvent actionEvent) throws IOException {
        CashierFormController.getFeedback().customerPane.setVisible(true);
        CashierFormController.getFeedback().btnClose.setVisible(true);

      /*  Parent root = FXMLLoader.load(Navigation.class.getResource("/lk/ijse/chicagosystem/view/AddNewCustomerForm.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }
}
