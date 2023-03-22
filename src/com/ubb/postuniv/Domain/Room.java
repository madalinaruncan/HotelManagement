package com.ubb.postuniv.Domain;

public class Room {
    private int id;
    private String name;
    private float price;
    private int bedNumber;
    private String type;

    public Room(int id, String name, float price, int bedNumber, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bedNumber = bedNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bedNumber=" + bedNumber +
                ", type='" + type + '\'' +
                '}';
    }
}
