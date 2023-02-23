package org.example.service;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.persistance.DepartmentPersistance;
import org.example.persistance.EmployeePersistance;
import org.example.presentation.DepartmentPresenter;
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
public class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentPersistance departmentPersistance;
    @Mock
    private EmployeePersistance employeePersistance;
    @Mock
    private DepartmentPresenter departmentPresenter;

    @Before
    public void setUp() {
        departmentService = new DepartmentServiceImpl(departmentPersistance, employeePersistance, departmentPresenter);
    }

    @Test
    public void department_isAdded_toPersistence() {
        Department department = new Department(1000, "Technology", 100000);
        departmentService.addDepartment(department);
        verify(departmentPersistance, times(1)).addDepartment(department);

    }

    @Test
    public void assignEmployeeToDepartment() {
        Department department = new Department(1000, "Technology", 100000);
        Employee employee = new Employee(101, "John", "Doe", 15000.0);
        when(departmentPersistance.getDepartmentBy(1000)).thenReturn(department);
        when(employeePersistance.getEmployeeBy(101)).thenReturn(employee);
        departmentService.assignEmployeeToDepartment(101, 1000);
        verify(departmentPersistance, times(1)).addEmployeeToDepartment(employee, department);
    }


}