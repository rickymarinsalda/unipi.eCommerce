package unipi.eCommerce.model;

import java.util.List;

public class Beer extends Product{
    private List<String> ingredients;
    private double alcholPercentage;
    private double liquidVolumeInML;

    public Beer() {}

    public Beer(String name, String shortDescription, String brand, String imageUrl, double price, int stock, List<String> ingredients, double alcholPercentage, double liquidVolumeInML) {
        super(name, shortDescription, brand, imageUrl, price, stock);
        this.ingredients = ingredients;
        this.alcholPercentage = alcholPercentage;
        this.liquidVolumeInML = liquidVolumeInML;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getAlcholPercentage() {
        return alcholPercentage;
    }

    public void setAlcholPercentage(double alcholPercentage) {
        this.alcholPercentage = alcholPercentage;
    }

    public double getLiquidVolumeInML() {
        return liquidVolumeInML;
    }

    public void setLiquidVolumeInML(double liquidVolumeInML) {
        this.liquidVolumeInML = liquidVolumeInML;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "ingredients=" + ingredients +
                ", alcholPercentage=" + alcholPercentage +
                ", liquidVolumeInML=" + liquidVolumeInML +
                ", product= " + super.toString() +
                '}';
    }
}
