package org.example.service;

import org.example.data.Employee;
import org.example.persistance.EmployeePersistance;
import org.example.presentation.EmployeePresenter;
import org.example.service.promotion.PromotionCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final int ID = 1000;
    private static final double SALARY = 15000.0;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeePersistance employeePersistance;
    @Mock
    private PromotionCalculator promotionCalculator;
    @Mock
    private EmployeePresenter employeePresenter;

    @Before
    public void setUp() {
        employeeService = new EmployeeServiceImpl(employeePersistance, promotionCalculator, employeePresenter);
    }

    @Test
    public void hire_sampleEmployee_employeeAddedToPersistence() {
        Employee employee = new Employee(ID, FIRST_NAME, LAST_NAME, SALARY);
        employeeService.hireEmployee(employee, ID);
        verify(employeePersistance, times(1)).addEmployee(employee, ID);
    }

    @Test
    public void promoteEmployee_existingEmployee_salaryUpdatedInPersistence() {
        Employee employee = new Employee(ID, FIRST_NAME, LAST_NAME, SALARY);
        double percentage = 10.0;
        PromotionCalculator mockedPromotionCalculator = Mockito.mock(PromotionCalculator.class);
        when(mockedPromotionCalculator.increaseSalary(employee, percentage)).thenReturn(16500.0);
        when(employeePersistance.getEmployeeBy(ID)).thenReturn(employee);
        employeeService.promoteEmployee(ID, percentage);
        verify(employeePersistance, times(1)).updateEmployee(employee);
    }
}