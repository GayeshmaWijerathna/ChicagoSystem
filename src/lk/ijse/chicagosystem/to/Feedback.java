package lk.ijse.chicagosystem.to;

public class Feedback {
    private int fbNo;
    private String fbTitle;
    private String fbDescription;
    private int ratings;
    private String orderid;

    public Feedback() {
    }

    public Feedback(int fbNo, String fbTitle, String fbDescription, int ratings, String orderid) {
        this.fbNo = fbNo;
        this.fbTitle = fbTitle;
        this.fbDescription = fbDescription;
        this.ratings = ratings;
        this.orderid = orderid;
    }

    public int getFbNo() {
        return fbNo;
    }

    public void setFbNo(int fbNo) {
        this.fbNo = fbNo;
    }

    public String getFbTitle() {
        return fbTitle;
    }

    public void setFbTitle(String fbTitle) {
        this.fbTitle = fbTitle;
    }

    public String getFbDescription() {
        return fbDescription;
    }

    public void setFbDescription(String fbDescription) {
        this.fbDescription = fbDescription;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fbNo=" + fbNo +
                ", fbTitle='" + fbTitle + '\'' +
                ", fbDescription='" + fbDescription + '\'' +
                ", ratings=" + ratings +
                ", orderid='" + orderid + '\'' +
                '}';
    }
}
