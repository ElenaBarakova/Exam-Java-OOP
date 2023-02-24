package org.example.persistance;

import org.example.data.Employee;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeePersistance implements EmployeePersistance {
    private final List<Employee> employees;

    public InMemoryEmployeePersistance() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee, int employeeId) {
        boolean employeeAlreadyExists = employees.stream()
                .anyMatch(e -> e.getEmployeeId() == employeeId);

        if (!employeeAlreadyExists) {
            employees.add(employee);
        } else {
             System.out.println("Employee with " + employee.getEmployeeId() + " already exists!");
        }
    }

    @Override
    public Employee removeEmployeeBy(int employeeId) {
        Employee found = getEmployeeBy(employeeId);
        employees.remove(found);
        return found;
    }

    @Override
    public Employee getEmployeeBy(int employeeId) {

        try {
            Employee e = employees.stream()
                    .filter(em -> em.getEmployeeId() == employeeId)
                    .findFirst()
                    .get();
            return e;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public void updateEmployee(Employee employee) {
        removeEmployeeBy(employee.getEmployeeId());
        addEmployee(employee, employee.getEmployeeId());
    }
}


