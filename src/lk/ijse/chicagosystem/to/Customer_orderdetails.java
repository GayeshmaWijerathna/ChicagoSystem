package lk.ijse.chicagosystem.to;

import lk.ijse.chicagosystem.db.Db;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.SQLException;

public class Customer_orderdetails {

    public static boolean setValue(Orders orders) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Db.orderDetails.size(); i++) {
            if (CrudUtil.execute("INSERT INTO customer_orderdetails VALUES (?,?,?,?,?)",
                    Db.orderDetails.get(i).getItemId(),
                    Db.orderDetails.get(i).getItemName(),
                    orders.getOrderId(),
                    Db.orderDetails.get(i).getQty(),
                    Db.orderDetails.get(i).getPrice()
            )) {
                System.out.println(i + " order details success");
            } else {
                return false;
            }
//            System.out.println(Db.orderDetails.get(i).getItemId());
//            System.out.println(orders.getOrderId());
//            System.out.println(Db.orderDetails.get(i).getQty());
//            System.out.println(Db.orderDetails.get(i).getPrice());

        }
        return true;
    }

}

