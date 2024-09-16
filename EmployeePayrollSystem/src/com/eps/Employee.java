package com.eps;


public class Employee {
    private String name;
    private double baseSalary;
    private double taxRate; // as a percentage, e.g., 20 for 20%

    public Employee(String name, double baseSalary, double taxRate) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.taxRate = taxRate;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double calculateTax() {
        return baseSalary * (taxRate / 100);
    }

    public double calculateNetSalary() {
        return baseSalary - calculateTax();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', baseSalary=" + baseSalary + ", taxRate=" + taxRate + "%}";
    }
}

