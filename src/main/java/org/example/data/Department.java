package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int departmentId;
    private String departmentName;
    private double yearlyBudget;
    private double leftOverBudget;
    private ArrayList<Employee> employees;

    public Department(int departmentId, String departmentName, int yearlyBudget) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.yearlyBudget = yearlyBudget;
        this.leftOverBudget=yearlyBudget;
        this.employees=new ArrayList<>();
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getYearlyBudget() {
        return yearlyBudget;
    }

    public void setYearlyBudget(int yearlyBudget) {
        this.yearlyBudget = yearlyBudget;
    }

    public double getLeftOverBudget() {
        return leftOverBudget;
    }

    public void setLeftOverBudget(double leftOverBudget) {
        this.leftOverBudget = leftOverBudget;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
