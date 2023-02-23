package org.example.service.promotion;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.persistance.DepartmentPersistance;
import org.example.persistance.EmployeePersistance;
import org.example.service.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PromotioncalulatorImplTest {

    @InjectMocks
    private PromotioncalulatorImpl promotioncalulator;
    @Mock
    private DepartmentPersistance departmentPersistance;


    @Before
    public void setUp() {
        promotioncalulator = new PromotioncalulatorImpl(departmentPersistance);
    }

    @Test
    public void increaseSalary_whenPercentage_greaterThan0() {
        double percentage = 10.0;
        Department department = new Department(1000, "Technology", 100000);
        Employee employee = new Employee(101, "John", "Doe", 15000.0);
        when(departmentPersistance.getDepartmentBy(1000)).thenReturn(department);
        double increasedSalary = promotioncalulator.increaseSalary(employee, percentage);
        assertEquals(16500, increasedSalary, 0);
    }
}