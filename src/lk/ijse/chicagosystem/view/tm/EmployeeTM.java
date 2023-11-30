package lk.ijse.chicagosystem.view.tm;

public class EmployeeTM {
    private String empId;
    private String name;
    private String userName;
    private String password;
    private String address;
    private String designation;
    private int contactNo;
    private double salary;

    public EmployeeTM() {
    }

    public EmployeeTM(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeTM(String empId, String name, String userName, String password, String address, String designation, int contactNo, double salary) {
        this.empId = empId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.designation = designation;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        return "EmployeeTM{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", designation='" + designation + '\'' +
                ", contactNo=" + contactNo +
                ", salary=" + salary +
                '}';
    }
}
