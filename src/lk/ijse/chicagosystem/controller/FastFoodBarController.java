package lk.ijse.chicagosystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.view.sm.OrderDetails;

public class FastFoodBarController {

    public Text itemName;
    public Text txtPrice;

    public Text lblIDFastFood;
    public RadioButton rBtnFastFood;


    public void setData(String id, String name, String price) {
        lblIDFastFood.setText(id);
        itemName.setText(name);
        txtPrice.setText(price);
    }

    public void fastFoodOnAction(ActionEvent actionEvent) {
        if (rBtnFastFood.isSelected()) {
            Db.orderDetails.add(new OrderDetails(
                    lblIDFastFood.getText(),
                    itemName.getText(),
                    "000",
                    txtPrice.getText()
            ));
            OrderForm2Controller.getQtyFocus().lblQty.requestFocus();
            OrderForm2Controller.instants.txtItemID.setText(lblIDFastFood.getText());
        } else {
            OrderForm2Controller.instants.txtItemID.setText("Select Items");
            for (int i = 0; i < Db.orderDetails.size(); i++) {
                if (Db.orderDetails.get(i).getItemId().equals(lblIDFastFood.getText())) {
                    Db.orderDetails.remove(i);
                }
            }
        }
    }

    private static FastFoodBarController selection;

    public FastFoodBarController(){
        selection=this;
    }
public static FastFoodBarController getDisSelection(){
        return selection;
}
}

