package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.Menu;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuModel {
    public static ResultSet getItems(String category) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM menu WHERE category=?", category);
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *FROM menu");
    }

    public static boolean addMenu(Menu menu) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO menu VALUES (?, ?, ?, ? )";
        return CrudUtil.execute(sql, menu.getmItemNo(), menu.getmItem(), menu.getPricePerOne(), menu.getCategory());
    }

    public static Menu search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM menu WHERE mItemNo = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Menu(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public static boolean Update(Menu menu) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE menu SET mItem=?, pricePerOne=?, category=? WHERE mItemNo=?",
                menu.getmItem(),
                menu.getPricePerOne(),
                menu.getCategory(),
                menu.getmItemNo());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM menu WHERE mItemNo='" + id + "'";
        return CrudUtil.execute(sql);
    }
}
