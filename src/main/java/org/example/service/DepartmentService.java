package org.example.service;


import org.example.data.Department;

public interface DepartmentService {
    void addDepartment(Department department);

    void updateDepartment(Department department);

    void assignEmployeeToDepartment(int employeeId, int departmentId);

    void  showDepartment(int departmentId);


}
