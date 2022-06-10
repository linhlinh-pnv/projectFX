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
//////// Khách hàng





    public ArrayList<Customer> getCustomer(){
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
                Customer customer = new Customer(
                        results.getInt("idKH"),
                        results.getString("Ho_ten"),
                        results.getString("Ten_SanPham"),
                        results.getInt("soluong")
                );
                list.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertCustomer(Customer customer){
        String sql = "INSERT INTO customer (Ho_ten, Ten_SanPham, soluong) VALUE ('"+customer.Ho_ten+"','"+customer.Ten_SanPham+"','"+customer.soluong+"')";
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomer(Customer customer){
        String sql = "UPDATE customer SET Ho_ten = '"+ customer.Ho_ten +"', image = '"+customer.Ten_SanPham+"', soluong = '"+customer.soluong+"' WHERE id = "+ customer.idKH;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer(int idKH){
        String sql = "DELETE FROM customer WHERE id = "+ idKH;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}