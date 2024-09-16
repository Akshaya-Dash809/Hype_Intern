package com.eps;


import java.util.Scanner;

public class EPS_main {
    public static void main(String[] args) {
        PayrollManager manager = new PayrollManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Generate All Pay Slips");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Salary: ");
                    double baseSalary = scanner.nextDouble();
                    System.out.print("Enter Tax Rate (percentage): ");
                    double taxRate = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Employee employee = new Employee(name, baseSalary, taxRate);
                    manager.addEmployee(employee);
                    System.out.println("Employee added.");
                    break;

                case 2:
                    manager.generateAllPaySlips();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
