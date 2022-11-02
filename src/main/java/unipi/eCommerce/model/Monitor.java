package unipi.eCommerce.model;

import java.util.Arrays;
import java.util.List;

public class Monitor extends Product{
    private double screenSizeInches;
    private int[] displayResolution;
    private List<String> specialFeatures;
    private double refreshRateHz;

    public Monitor() {};

    public Monitor(String name, String shortDescription, String brand, String imageUrl, double price, int stock, double screenSizeInches, int[] displayResolution, List<String> specialFeatures, double refreshRateHz) {
        super(name, shortDescription, brand, imageUrl, price, stock);
        this.screenSizeInches = screenSizeInches;
        this.displayResolution = displayResolution;
        this.specialFeatures = specialFeatures;
        this.refreshRateHz = refreshRateHz;
    }

    public double getScreenSizeInches() {
        return screenSizeInches;
    }

    public void setScreenSizeInches(double screenSizeInches) {
        this.screenSizeInches = screenSizeInches;
    }

    public int[] getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(int[] displayResolution) {
        this.displayResolution = displayResolution;
    }

    public List<String> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(List<String> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public double getRefreshRateHz() {
        return refreshRateHz;
    }

    public void setRefreshRateHz(double refreshRateHz) {
        this.refreshRateHz = refreshRateHz;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "screenSizeInches=" + screenSizeInches +
                ", displayResolution=" + Arrays.toString(displayResolution) +
                ", specialFeatures=" + specialFeatures +
                ", refreshRateHz=" + refreshRateHz +
                ", product=" + super.toString() +
                '}';
    }
}
