package lk.ijse.chicagosystem.view.tm;

public class FeedbackTM {
    private String fbNo;
    private String fbTitle;
    private String fbDescription;
    private String ratings;

    public FeedbackTM() {
    }

    public FeedbackTM(String fbNo, String fbTitle, String fbDescription, String ratings) {
        this.fbNo = fbNo;
        this.fbTitle = fbTitle;
        this.fbDescription = fbDescription;
        this.ratings = ratings;
    }

    public String getFbNo() {
        return fbNo;
    }

    public void setFbNo(String fbNo) {
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

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "FeedbackTM{" +
                "fbNo='" + fbNo + '\'' +
                ", fbTitle='" + fbTitle + '\'' +
                ", fbDescription='" + fbDescription + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }
}
