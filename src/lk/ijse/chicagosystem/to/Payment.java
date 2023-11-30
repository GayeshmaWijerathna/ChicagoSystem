package lk.ijse.chicagosystem.to;

import java.util.Date;

public class Payment {
    private String payId;
    private String description;
    private Date date;

    public Payment(String payId, String description, Date date) {
        this.payId = payId;
        this.description = description;
        this.date = date;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payId='" + payId + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
