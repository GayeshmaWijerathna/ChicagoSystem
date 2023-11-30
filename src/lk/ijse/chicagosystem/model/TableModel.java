package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.ReserveTable;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableModel {

    public static boolean addTableData(ReserveTable reserveTable) throws SQLException, ClassNotFoundException, SQLException {
        String sql = "INSERT INTO reservetable VALUES (?, ?, ?, ?, ?, ? )";
        return CrudUtil.execute(sql, reserveTable.getTblNo(), reserveTable.getCustomerId(), reserveTable.getNoOfSeats(), reserveTable.getResDate(), reserveTable.getReservationStatus(), reserveTable.getCustomerName());
    }


    public static ResultSet getAll2() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM reservetable");
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM reservetable WHERE tblNo='" + id + "'";
        return CrudUtil.execute(sql);
    }
}

