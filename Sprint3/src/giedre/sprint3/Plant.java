package giedre.sprint3;

import java.io.Serializable;
import java.util.Objects;

public class Plant implements Comparable<Plant> {
    private String name;
    private String exposure; //sun, partial sun, shade
    private int height;
    private double price;

    public Plant() {}

    public Plant(String name, String exposure, int height, double price) {
        this.name = name;
        this.exposure = exposure;
        this.height = height;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{ " +
                "name: " + name +
                ", exposure: " + exposure +
                ", height: " + height +
                ", price: " + price +
                " }";
    }

    @Override
    public int compareTo(Plant anotherPlant) {
        return Double.compare(this.price, anotherPlant.price);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return height == plant.height &&
                Double.compare(plant.price, price) == 0 &&
                Objects.equals(name, plant.name) &&
                Objects.equals(exposure, plant.exposure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, exposure, height, price);
    }
}

