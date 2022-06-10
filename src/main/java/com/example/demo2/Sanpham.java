package com.example.demo2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Sanpham {
    public int id;
    public String name;
    public String image;
    public int price;
    public int soluong;

    public Sanpham (int id, String name, String image, int price, int soluong) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.soluong = soluong;
    }

    public Sanpham (String name, String image, int price, int soluong) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int name) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
