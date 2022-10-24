package unipi.eCommerce.model;

public class Book extends Product{
    private String summery;
    private String language;
    private int numberPages;


    public Book(String name, String shortDescription, String brand, String imageUrl, double price, int stock, String summery, String language, int numberPages) {
        super(name, shortDescription, brand, imageUrl, price, stock);
        this.summery = summery;
        this.language = language;
        this.numberPages = numberPages;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
}
