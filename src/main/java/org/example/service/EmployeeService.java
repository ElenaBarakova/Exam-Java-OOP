package org.example.service;

import org.example.data.Employee;

public interface EmployeeService {
    void hireEmployee(Employee employee, int employeeId);

    void promoteEmployee(int employeeId, double percentage);

    void showEmployee(int employeeId);
}
