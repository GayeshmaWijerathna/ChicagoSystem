package lk.ijse.chicagosystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.view.sm.OrderDetails;

public class RiceBarController {
    public Text itemName;
    public Text txtPrice;
    public RadioButton rBtnRice;
    public Text lblIDRice;

    public void setData(String id, String name, String price) {
        lblIDRice.setText(id);
        itemName.setText(name);
        txtPrice.setText(price);
    }

    public void riceOnAction(ActionEvent actionEvent) {
        if (rBtnRice.isSelected()) {
            Db.orderDetails.add(new OrderDetails(
                    lblIDRice.getText(),
                    itemName.getText(),
                    "000",
                    txtPrice.getText()
            ));
            OrderForm2Controller.getQtyFocus().lblQty.requestFocus();
            OrderForm2Controller.instants.txtItemID.setText(lblIDRice.getText());
        } else {
            OrderForm2Controller.instants.txtItemID.setText("Select Items");
            for (int i = 0; i < Db.orderDetails.size(); i++) {
                if (Db.orderDetails.get(i).getItemId().equals(lblIDRice.getText())) {
                    Db.orderDetails.remove(i);
                }
            }
        }
    }

    private static RiceBarController selection;

    public RiceBarController() {
        selection = this;
    }

    public static RiceBarController getDisSelection() {
        return selection;
    }
}
