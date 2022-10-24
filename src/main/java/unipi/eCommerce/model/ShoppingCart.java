package unipi.eCommerce.model;

public class ShoppingCart {
    private long updatedDate;
    // TO DO
    // private Customer customer;

    public ShoppingCart(long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }
}
