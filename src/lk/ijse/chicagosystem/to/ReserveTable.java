package lk.ijse.chicagosystem.to;

import java.time.LocalDate;


public class ReserveTable {
    private String tblNo;
    private String customerId;
    private int noOfSeats;
    private LocalDate resDate;
    private String reservationStatus;
    private String customerName;

    public ReserveTable(String tblNo, String customerId, int noOfSeats, LocalDate resDate, String reservationStatus, String customerName) {
        this.tblNo = tblNo;
        this.customerId = customerId;
        this.noOfSeats = noOfSeats;
        this.resDate = resDate;
        this.reservationStatus = reservationStatus;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "ReserveTable{" +
                "tblNo='" + tblNo + '\'' +
                ", customerId='" + customerId + '\'' +
                ", noOfSeats=" + noOfSeats +
                ", resDate=" + resDate +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }


    public String getTblNo() {
        return tblNo;
    }

    public void setTblNo(String tblNo) {
        this.tblNo = tblNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public LocalDate getResDate() {
        return resDate;
    }

    public void setResDate(LocalDate resDate) {
        this.resDate = resDate;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
