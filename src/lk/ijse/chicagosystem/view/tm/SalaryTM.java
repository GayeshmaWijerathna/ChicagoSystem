package lk.ijse.chicagosystem.view.tm;

public class SalaryTM {

    private String empId;
    private String name;
    private double salary;
    private double deduction;
    private double grossSalary;


    public SalaryTM(String empId, String name, double salary, double deduction, double grossSalary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.setDeduction(deduction);
        this.setGrossSalary(grossSalary);
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryTM(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;

    }

    public SalaryTM(double deduction, double grossSalary) {
        this.setDeduction(deduction);
        this.setGrossSalary(grossSalary);

    }

    @Override
    public String toString() {
        return "SalaryTable{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
}
