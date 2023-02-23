package org.example.persistance;


import org.example.data.Department;
import org.example.data.Employee;

import java.util.List;

public interface DepartmentPersistance {
    void addDepartment(Department department);
    void addEmployeeToDepartment(Employee employee, Department department);

    Department getDepartmentBy(int departmentId);

    Department getDepartmentBy(String departmentName);
}
