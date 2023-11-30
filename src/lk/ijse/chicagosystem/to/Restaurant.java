package lk.ijse.chicagosystem.to;

public class Restaurant {
    private String regNo;
    private String name;
    private String address;
    private int contactNo;

    public Restaurant(String regNo, String name, String address, int contactNo) {
        this.regNo = regNo;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "regNo='" + regNo + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }
}
