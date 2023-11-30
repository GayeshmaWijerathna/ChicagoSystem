package lk.ijse.chicagosystem.model;

import javafx.scene.control.Alert;
import lk.ijse.chicagosystem.db.DBConnection;
import lk.ijse.chicagosystem.to.Customer_orderdetails;
import lk.ijse.chicagosystem.to.Orders;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT orderId FROM orders ORDER BY LENGTH(orderId),orderId");
    }

    public static boolean placeOrder(Orders orders) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (setValue(orders)) {
                if (Customer_orderdetails.setValue(orders)) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    new Alert(Alert.AlertType.WARNING, "Error! Not Updated.").show();
                }
            } else {
                connection.rollback();
                new Alert(Alert.AlertType.WARNING, "Error! Not Updated.").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    private static boolean setValue(Orders orders) throws SQLException, ClassNotFoundException {
//        System.out.println(orders.getOrderId());
//        System.out.println(orders.getCus_name());
//        System.out.println(orders.getOrderDate());
//        System.out.println( orders.getTime());
//        System.out.println(orders.getAmount());
//        System.out.println(orders.getOrderType());
//        System.out.println(orders.getCusId());
        return CrudUtil.execute("INSERT INTO orders VALUES (?,?,?,?,?,?,?)",
                orders.getOrderId(),
                orders.getCus_name(),
                orders.getOrderDate(),
                orders.getTime(),
                orders.getAmount(),
                orders.getOrderType(),
                orders.getCusId()

        );
    }
}
