package lk.ijse.chicagosystem.view.tm;

public class CustomerTM {
    public CustomerTM() {
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "cusId='" + cusId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }

    private String cusId;
    private String name;
    private String address;
    private int contactNo;

    public CustomerTM(String cusId, String name, String address, int contactNo) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }


    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
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
}
