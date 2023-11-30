package lk.ijse.chicagosystem.to;

public class Menu {
    private String mItemNo;
    private String mItem;
    private double pricePerOne;
    private String category;

    public Menu(String menuItemNo, String mItemName, Double mPriceperOne, String[] category) {

    }

    @Override
    public String toString() {
        return "Menu{" +
                "mItemNo='" + mItemNo + '\'' +
                ", mItem='" + mItem + '\'' +
                ", pricePerOne=" + pricePerOne +
                ", category='" + category + '\'' +
                '}';
    }

    public Menu(String mItemNo, String mItem, double pricePerOne, String category) {
        this.mItemNo = mItemNo;
        this.mItem = mItem;
        this.pricePerOne = pricePerOne;
        this.category = category;
    }


    public String getmItemNo() {
        return mItemNo;
    }

    public void setmItemNo(String mItemNo) {
        this.mItemNo = mItemNo;
    }

    public String getmItem() {
        return mItem;
    }

    public void setmItem(String mItem) {
        this.mItem = mItem;
    }

    public double getPricePerOne() {
        return pricePerOne;
    }

    public void setPricePerOne(double pricePerOne) {
        this.pricePerOne = pricePerOne;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
