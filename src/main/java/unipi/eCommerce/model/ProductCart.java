package unipi.eCommerce.model;

public class ProductCart {
    private int quantity;
    private double total;
    private Product product;
    private ShoppingCart shoppingCart;

    public ProductCart(int quantity, double total, Product product, ShoppingCart shoppingCart) {
        this.quantity = quantity;
        this.total = total;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
