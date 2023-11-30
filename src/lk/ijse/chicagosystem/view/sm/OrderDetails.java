package lk.ijse.chicagosystem.view.sm;

public class OrderDetails {
    private String itemId;
    private String itemName;
    private String qty;
    private String price;

    public OrderDetails() {
    }

    public OrderDetails(String itemId, String itemName, String qty, String price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "orderDetails{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty='" + qty + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
