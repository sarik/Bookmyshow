package com.scaler.bookmyshow;

public class Laptop implements  Comparable<Laptop>{

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    String description;
    long price;

    public Laptop(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        int diff = (int) (this.price - o.price);
        return diff*-1;
    }
}
