package lk.ijse.chicagosystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.view.sm.OrderDetails;

public class BiteBarController {

    public Text itemName;
    public Text txtPrice;
    public RadioButton rBtnBites;
    public Text lblIDBite;

    public void setData(String id, String name, String price) {
        lblIDBite.setText(id);
        itemName.setText(name);
        txtPrice.setText(price);
    }

    public void biteOnAction(ActionEvent actionEvent) {
        if (rBtnBites.isSelected()) {
            Db.orderDetails.add(new OrderDetails(
                    lblIDBite.getText(),
                    itemName.getText(),
                    "000",
                    txtPrice.getText()
            ));
            OrderForm2Controller.getQtyFocus().lblQty.requestFocus();
            OrderForm2Controller.instants.txtItemID.setText(lblIDBite.getText());
        } else {
            OrderForm2Controller.instants.txtItemID.setText("Select Items");

            for (int i = 0; i < Db.orderDetails.size(); i++) {
                if (Db.orderDetails.get(i).getItemId().equals(lblIDBite.getText())) {
                    Db.orderDetails.remove(i);
                }
            }
        }
    }

    private static BiteBarController selection;

    public BiteBarController() {
        selection = this;
    }

    public static BiteBarController getDisSelection() {
        return selection;
    }


}