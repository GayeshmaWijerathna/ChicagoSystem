package lk.ijse.chicagosystem.view.tm;

public class TableReservationTM {
    private String CusId;
    private String tblNo;
    private String noOfSeats;
    private String CustName;
    private String resrvationStatus;
    private String resDate;

    public TableReservationTM() {
    }

    public TableReservationTM(String cusId, String tblNo, String noOfSeats, String custName, String resrvationStatus, String resDate) {
        CusId = cusId;
        this.tblNo = tblNo;
        this.noOfSeats = noOfSeats;
        CustName = custName;
        this.resrvationStatus = resrvationStatus;
        this.resDate = resDate;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getTblNo() {
        return tblNo;
    }

    public void setTblNo(String tblNo) {
        this.tblNo = tblNo;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getResrvationStatus() {
        return resrvationStatus;
    }

    public void setResrvationStatus(String resrvationStatus) {
        this.resrvationStatus = resrvationStatus;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    @Override
    public String toString() {
        return "TableReservationTM{" +
                "CusId='" + CusId + '\'' +
                ", tblNo='" + tblNo + '\'' +
                ", noOfSeats='" + noOfSeats + '\'' +
                ", CustName='" + CustName + '\'' +
                ", resrvationStatus='" + resrvationStatus + '\'' +
                ", resDate='" + resDate + '\'' +
                '}';
    }
}
