package unipi.eCommerce.model;

public class Product {
    private String name;
    private String shortDescription;
    private String brand;
    private String imageUrl;
    private double price;
    private int stock;

    public Product(String name, String shortDescription, String brand, String imageUrl, double price, int stock) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.brand = brand;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
