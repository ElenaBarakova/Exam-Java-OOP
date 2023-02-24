package org.example.presentation;

import org.example.data.Employee;

public class ConsoleEmployeePresenter implements EmployeePresenter {
    @Override
    public void displayEmployee(Employee employee) {

            String employeeString = String.format("Employee ID: %d, name: %s %s, Department: %s, Salary: %.2f %n",
                    employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmployeeDepartmentName(), employee.getYearlySalary());
            System.out.println(employeeString);
    }
}
