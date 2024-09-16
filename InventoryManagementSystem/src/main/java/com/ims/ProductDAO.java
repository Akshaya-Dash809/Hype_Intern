package com.ims;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Products (ProductName, Category, Price, StockLevel) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getCategory());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStockLevel());
            stmt.executeUpdate();
        }
    }

    public Product getProduct(int productId) throws SQLException {
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setCategory(rs.getString("Category"));
                product.setPrice(rs.getDouble("Price"));
                product.setStockLevel(rs.getInt("StockLevel"));
                return product;
            }
            return null;
        }
    }

    public void printAllProducts() throws SQLException {
        String sql = "SELECT * FROM Products";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setCategory(rs.getString("Category"));
                product.setPrice(rs.getDouble("Price"));
                product.setStockLevel(rs.getInt("StockLevel"));
                System.out.println(product);
            }
        }
    }
}
