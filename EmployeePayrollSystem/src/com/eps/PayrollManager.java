package com.eps;


import java.util.ArrayList;
import java.util.List;

public class PayrollManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void generateAllPaySlips() {
        for (Employee employee : employees) {
            PaySlip paySlip = new PaySlip(employee);
            paySlip.generatePaySlip();
        }
    }
}

