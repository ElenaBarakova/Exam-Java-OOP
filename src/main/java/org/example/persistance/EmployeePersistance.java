package org.example.persistance;

import org.example.data.Employee;

import java.util.List;

public interface EmployeePersistance {
    List<Employee> getEmployees();

    void addEmployee(Employee employee, int employeeId);

    Employee removeEmployeeBy(int employeeId);

    Employee getEmployeeBy(int employeeId);

    void updateEmployee(Employee employee);
}
