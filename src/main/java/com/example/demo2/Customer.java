package com.example.demo2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Customer {
    public int idKH;
    public String Ho_ten;
    public String Ten_SanPham;
    public int soluong;

    public Customer (int idKH, String Ho_ten, String Ten_SanPham, int soluong) {
        this.idKH = idKH;
        this.Ho_ten = Ho_ten;
        this.Ten_SanPham = Ten_SanPham;
        this.soluong = soluong;
    }

    public Customer (String Ho_ten, String Ten_SanPham, int soluong) {
        this.Ho_ten = Ho_ten;
        this.Ten_SanPham = Ten_SanPham;
        this.soluong = soluong;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int name) {
        this.idKH = idKH;
    }

    public String Ho_ten() {
        return Ho_ten;
    }

    public void setHo_ten(String Ho_ten) {
        this.Ho_ten = Ho_ten;
    }

    public String getTen_SanPham() {
        return Ten_SanPham;
    }

    public void setTen_SanPham(String Ten_SanPham) {
        this.Ten_SanPham = Ten_SanPham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
