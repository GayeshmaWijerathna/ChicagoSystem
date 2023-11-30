package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.Customer;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static ResultSet getNameForId(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT name FROM customer WHERE cusId=?", id);
    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT cusId FROM customer");
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT cusId FROM customer ORDER BY cusId DESC LIMIT 1");
    }

    public static boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ? )";
        return CrudUtil.execute(sql, customer.getCusId(), customer.getName(), customer.getAddress(), customer.getContact());
    }

    public static Customer search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  *FROM customer WHERE cusId =?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean Update(Customer customer) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE Customer SET name=?,address=?,contactNo=? WHERE cusId=?",
                customer.getName(),
                customer.getAddress(),
                customer.getContact(),
                customer.getCusId());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE cusId='" + id + "'";
        return CrudUtil.execute(sql);
    }

    public static Customer search2(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  *FROM customer WHERE cusId =? || contactNo=?";
        ResultSet result = CrudUtil.execute(sql, id, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static Customer searchCusName(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  *FROM customer WHERE name=?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }


    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM customer");
    }

}