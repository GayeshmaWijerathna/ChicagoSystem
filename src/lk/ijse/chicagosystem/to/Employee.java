package lk.ijse.chicagosystem.to;

public class Employee {
    private String empId;
    private String name;
    private String userName;
    private String password;
    private String address;
    private String role;
    private int contactNo;
    private double salary;

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public Employee(String empId, String name, String userName, String password, String address, String role, int contactNo, double salary) {
        this.empId = empId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.role = role;
        this.contactNo = contactNo;
        this.salary = salary;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", contactNo=" + contactNo +
                ", salary=" + salary +
                '}';
    }
}
