package com.eps;


public class PaySlip {
    private Employee employee;

    public PaySlip(Employee employee) {
        this.employee = employee;
    }

    public void generatePaySlip() {
        System.out.println("==== Pay Slip ====");
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Base Salary: $" + employee.getBaseSalary());
        System.out.println("Tax Rate: " + employee.getTaxRate() + "%");
        System.out.println("Tax Amount: $" + employee.calculateTax());
        System.out.println("Net Salary: $" + employee.calculateNetSalary());
        System.out.println("==================");
    }
}

