package org.example.persistance;


import org.example.data.Department;
import org.example.data.Employee;

import java.util.List;

public interface DepartmentPersistance {
    void addDepartment(Department department);

    Department removeDepartmentBy(int departmentId);

    void updateDepartment(Department department);

    void addEmployeeToDepartment(Employee employee, Department department);

    Department getDepartmentBy(int departmentId);

    Department getDepartmentBy(String departmentName);

    List<Department> getDepartments();
}
