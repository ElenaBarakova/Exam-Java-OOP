package org.example.persistance;

import org.example.data.Department;
import org.example.data.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class InMemoryDepartmentPersistance implements DepartmentPersistance {
    private final List<Department> departments;

    public InMemoryDepartmentPersistance() {
        this.departments = new ArrayList<>();
    }

    @Override
    public void addDepartment(Department department) {

        boolean departmentAlreadyExists = departments.stream()
                .anyMatch(d -> d.getDepartmentId() == department.getDepartmentId());

        if (!departmentAlreadyExists) {
            departments.add(department);
        } else {
            System.out.println("Department with " + department.getDepartmentId() + " already exists!");
        }

    }

    @Override
    public void addEmployeeToDepartment(Employee employee, Department department) {
        ArrayList<Employee> employees = department.getEmployees();
        double yearlyLeftOverBudget = department.getLeftOverBudget();
        double yearlySalary = employee.getYearlySalary();
        if (yearlyLeftOverBudget - yearlySalary >= 0) {
            double newLeftOverBudget = yearlyLeftOverBudget - yearlySalary;
            department.setLeftOverBudget(newLeftOverBudget);
            employees.add(employee);
            department.setEmployees(employees);
            employee.setEmployeeDepartmentName(department.getDepartmentName());
        } else {
            System.out.println("Unable to add employee " + employee.getEmployeeId() + " to department " +
                    department.getDepartmentId() + " as there is not enough budget!");
        }


    }
    @Override
    public Department getDepartmentBy(String departmentName) {
        boolean dFound = departments.stream().anyMatch(de -> de.getDepartmentName().equals(departmentName));

        if (!dFound) {
            System.out.println("Department with name " + departmentName + " does not exist!");
        }
        Department d = departments.stream()
                .filter(de -> de.getDepartmentName().equals(departmentName))
                .findFirst()
                .get();
        return d;
    }

    @Override
    public Department getDepartmentBy(int departmentId) {

        try{
            Department d = departments.stream()
                    .filter(de -> de.getDepartmentId() == departmentId)
                    .findFirst()
                    .get();
            return d;
        }catch (NoSuchElementException e){
            return null;
        }

    }



}
