package com.ims;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Stock Level: ");
                        int stockLevel = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Product newProduct = new Product();
                        newProduct.setProductName(name);
                        newProduct.setCategory(category);
                        newProduct.setPrice(price);
                        newProduct.setStockLevel(stockLevel);

                        productDAO.addProduct(newProduct);
                        System.out.println("Product added successfully.");
                        break;

                    case 2:
                        productDAO.printAllProducts();
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
