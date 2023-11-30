package lk.ijse.chicagosystem.to;

public class Orders {
    private String orderId;
    private String cus_name;
    private String orderDate;
    private String time;
    private String amount;
    private String orderType;
    private String cusId;

    public Orders() {
    }

    public Orders(String orderId, String cus_name, String orderDate, String time, String amount, String orderType, String cusId) {
        this.orderId = orderId;
        this.cus_name = cus_name;
        this.orderDate = orderDate;
        this.time = time;
        this.amount = amount;
        this.orderType = orderType;
        this.cusId = cusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", cus_name='" + cus_name + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", time='" + time + '\'' +
                ", amount='" + amount + '\'' +
                ", orderType='" + orderType + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
