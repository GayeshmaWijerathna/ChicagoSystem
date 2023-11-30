package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.Employee;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {

    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException, SQLException {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
        return CrudUtil.execute(sql, employee.getEmpId(), employee.getName(), employee.getUserName(), employee.getPassword(), employee.getAddress(), employee.getRole(), employee.getContactNo(), employee.getSalary());
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM employee WHERE empId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getInt(7),
                    result.getDouble(8)
            );
        }
        return null;
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT empId FROM employee ORDER BY empId DESC LIMIT 1");
    }

    public static boolean Update(Employee employee) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE Employee SET name=?,userName=?,password=?,address=?,designation=?,contactNo=?,salary=? WHERE empId=?",
                employee.getName(),
                employee.getUserName(),
                employee.getPassword(),
                employee.getAddress(),
                employee.getRole(),
                employee.getContactNo(),
                employee.getSalary(),
                employee.getEmpId());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE empId='" + id + "'";
        return CrudUtil.execute(sql);
    }


}
