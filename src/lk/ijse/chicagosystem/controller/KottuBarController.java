package lk.ijse.chicagosystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.view.sm.OrderDetails;

import java.io.IOException;

public class KottuBarController {


    public Text itemName;
    public Text txtPrice;
    public RadioButton rBtnKottu;
    public Text lblIDKottu;

    public void setData(String id, String name, String price) {
        lblIDKottu.setText(id);
        itemName.setText(name);
        txtPrice.setText(price);
    }


    public void kottuOnAction(ActionEvent actionEvent) throws IOException {
        if (rBtnKottu.isSelected()) {
            Db.orderDetails.add(new OrderDetails(
                    lblIDKottu.getText(),
                    itemName.getText(),
                    "000",
                    txtPrice.getText()

            ));
            OrderForm2Controller.getQtyFocus().lblQty.requestFocus();
            OrderForm2Controller.instants.txtItemID.setText(lblIDKottu.getText());
        } else {
            OrderForm2Controller.instants.txtItemID.setText("Select Items");
            for (int i = 0; i < Db.orderDetails.size(); i++) {

                if (Db.orderDetails.get(i).getItemId().equals(lblIDKottu.getText())) {
                    Db.orderDetails.remove(i);
                }

            }

        }

    }

    private static KottuBarController selection;

    public KottuBarController() {
        selection = this;
    }

    public static KottuBarController getDisSelection() {
        return selection;
    }


}
