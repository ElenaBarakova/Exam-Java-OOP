package org.example.persistance;

import org.example.data.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class InMemoryEmployeePersistanceTest {

    @InjectMocks
    private InMemoryEmployeePersistance inMemoryEmployeePersistance;

    @Mock
    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        inMemoryEmployeePersistance = new InMemoryEmployeePersistance();
        this.employees = new ArrayList<>();
    }

    @Test
    public void getEmployees() {
        Employee employee1 = new Employee(1000, "John", "Doe", 10000.0);
        Employee employee2 = new Employee(10002, "John2", "Doe2", 10002.0);
        employees.add(employee1);
        employees.add(employee2);
        List<Employee> employeeList = inMemoryEmployeePersistance.getEmployees();
        Assert.assertEquals(employeeList.size(), employees.size());
    }

    @Test
    public void addEmployee() {
        Employee employee1 = new Employee(1000, "John", "Doe", 10000.0);
        inMemoryEmployeePersistance.addEmployee(employee1, 1000);
        List<Employee> employeeList = inMemoryEmployeePersistance.getEmployees();
        Assert.assertTrue(employeeList.contains(employee1));
    }

    @Test
    public void removeEmployeeBy() {
        Employee employee1 = new Employee(1000, "John", "Doe", 10000.0);
        Employee employee2 = new Employee(10002, "John2", "Doe2", 10002.0);
        employees.add(employee1);
        employees.add(employee2);
        inMemoryEmployeePersistance.removeEmployeeBy(1000);
        List<Employee> employeeList = inMemoryEmployeePersistance.getEmployees();
        Assert.assertFalse(employeeList.contains(employee1));
    }


    @Test
    public void updateEmployee() {
        Employee employee1 = new Employee(1000, "John", "Doe", 10000.0);
        Employee employee2 = new Employee(10002, "John2", "Doe2", 10002.0);
        employees.add(employee1);
        inMemoryEmployeePersistance.updateEmployee(employee2);
        List<Employee> employeeList = inMemoryEmployeePersistance.getEmployees();
        Assertions.assertTrue(employeeList.contains(employee2));
    }
}