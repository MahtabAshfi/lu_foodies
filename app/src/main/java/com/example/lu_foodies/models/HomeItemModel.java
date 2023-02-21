package com.example.lu_foodies.models;

public class HomeItemModel {
    int image;
    String name;
    String time;
    String price;

    public HomeItemModel(int image, String name, String time, String price) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
