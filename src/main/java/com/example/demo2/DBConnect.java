package com.example.demo2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    private Connection connection;

    public static final String URL = "jdbc:mysql://localhost/shop";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public DBConnect(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Sanpham> getSanpham(){
        ArrayList<Sanpham> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
//                System.out.println(results.getInt("id"));
//                System.out.println(results.getString("name"));
//                System.out.println(results.getFloat("score"));
                Sanpham sanpham = new Sanpham(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getString("image"),
                        results.getInt("price"),
                        results.getInt("soluong")
                );
                list.add(sanpham);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertSanpham(Sanpham sanpham){
        String sql = "INSERT INTO sanpham (name, image, price, soluong) VALUE ('"+sanpham.name+"','"+sanpham.image+"','"+sanpham.price+"','"+sanpham.soluong+"')";
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSanpham(Sanpham sanpham){
        String sql = "UPDATE sanpham SET name = '"+ sanpham.name +"', image = '"+sanpham.image+"', price = '"+sanpham.price+"', soluong = '"+sanpham.soluong+"' WHERE id = "+ sanpham.id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSanpham(int id){
        String sql = "DELETE FROM sanpham WHERE id = "+ id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}