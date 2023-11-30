package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.Employee;
import lk.ijse.chicagosystem.to.Salary;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Salary table ekata data daganna ona
public class SalaryModel {

    public static ResultSet getSalaryDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT empId,name,salary FROM employee");
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  empId,name FROM employee WHERE empId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }

    public static boolean saveSalary(ArrayList<Salary> salaryArrayList) throws SQLException, ClassNotFoundException {

        for (Salary salary : salaryArrayList) {
            if (!Save(salary)) {
                return false;
            }
        }
        return true;
    }

    private static boolean Save(Salary salary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO salary VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, salary.getEmpId(), salary.getName(), salary.getGrossSalary(), salary.getDeductions(), salary.getNetSalary());
    }


    public static boolean Update(Salary salary) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE salary SET name=?, grossSalary=?, totalDeduction=?, netSalary=? WHERE empId=?",
                salary.getName(),
                salary.getGrossSalary(),
                salary.getDeductions(),
                salary.getNetSalary(),
                salary.getEmpId());
    }
}
