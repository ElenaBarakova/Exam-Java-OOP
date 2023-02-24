package org.example.service;


import org.example.data.Department;
import org.example.data.Employee;
import org.example.persistance.DepartmentPersistance;
import org.example.persistance.EmployeePersistance;
import org.example.presentation.DepartmentPresenter;


public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentPersistance departmentPersistance;
    private final EmployeePersistance employeePersistance;
    private final DepartmentPresenter departmentPresenter;

    public DepartmentServiceImpl(DepartmentPersistance departmentPersistance, EmployeePersistance employeePersistance, DepartmentPresenter departmentPresenter) {
        this.departmentPersistance = departmentPersistance;
        this.employeePersistance = employeePersistance;
        this.departmentPresenter = departmentPresenter;
    }

    @Override
    public void addDepartment(Department department) {
        departmentPersistance.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentPersistance.updateDepartment(department);
    }



    @Override
    public void assignEmployeeToDepartment(int employeeId, int departmentId) {
        if (departmentPersistance.getDepartmentBy(departmentId) == null) {
            System.out.println("Department with ID " + departmentId + " does not exist!");

        }
        if (employeePersistance.getEmployeeBy(employeeId)==null){
            System.out.println("Employee with ID " + employeeId + " does not exist!");
        }
        if (departmentPersistance.getDepartmentBy(departmentId) != null && employeePersistance.getEmployeeBy(employeeId)!=null){
            Department department = departmentPersistance.getDepartmentBy(departmentId);
            Employee employee = employeePersistance.getEmployeeBy(employeeId);
            departmentPersistance.addEmployeeToDepartment(employee, department);
        }
    }

    @Override
    public void showDepartment(int departmentId) {
        Department department = departmentPersistance.getDepartmentBy(departmentId);
        departmentPresenter.displayDepartment(department);
    }
}
