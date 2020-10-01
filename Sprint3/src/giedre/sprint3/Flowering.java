package giedre.sprint3;

import java.util.function.Function;

public class Flowering extends Plant {

    private String colorPalette; //red, pink, white, purple, yellow

    public Flowering() {}

    public Flowering(String name, String exposure, int height, double price, String colorPalette) {
        super(name, exposure, height, price);
        this.colorPalette = colorPalette;
    }

    public String getColorPalette() {
        return colorPalette;
    }

    public void setColorPalette(String colorPalette) {
        this.colorPalette = colorPalette;
    }

    @Override
    public String toString() {
        return "{ " +
                "name: " + this.getName() +
                ", exposure: " + this.getExposure() +
                ", height: " + this.getHeight() +
                ", price: " + this.getPrice() +
                ", colorPalette: " + colorPalette +
                " }";
    }



}
