package lk.ijse.chicagosystem.to;

import lk.ijse.chicagosystem.model.SalaryModel;

public class Salary extends SalaryModel {
    private String empId;
    private String name;
    private Double netSalary;
    private Double deductions;
    private Double grossSalary;

    public Salary(Double grossSalary, Double deductions) {
        this.grossSalary = grossSalary;
        this.deductions = deductions;
    }


    public Salary(Double deduction) {
    }

    @Override
    public String toString() {
        return "Salary{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", grossSalary=" + grossSalary +
                ", deductions=" + deductions +
                ", netSalary=" + netSalary +
                '}';
    }

    public Salary(String empId, String name, Double grossSalary, Double deductions, Double netSalary) {
        this.empId = empId;
        this.name = name;
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
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

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }
}
