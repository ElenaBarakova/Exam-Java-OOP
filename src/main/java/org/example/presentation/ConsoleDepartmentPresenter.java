package org.example.presentation;

import org.example.data.Department;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleDepartmentPresenter implements DepartmentPresenter {
    @Override
    public void displayDepartment(Department department) {
        ArrayList<Integer> employeeNames = new ArrayList<>();
        department.getEmployees().forEach(employee -> employeeNames.add(employee.getEmployeeId()));

        String departmentString = String.format("——————————————%n" +
                "Department: %s %n" +
                "ID: %d %n" +
                "Budget: %.2f$/year.%n" +
                "Not allocated: %.2f %n" +
                "Employees: %s %n" +
                "——————————————", department.getDepartmentName(), department.getDepartmentId(), department.getYearlyBudget(),department.getLeftOverBudget(),
                Arrays.toString(employeeNames.toArray()));
        System.out.println(departmentString);
    }
}
