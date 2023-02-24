package org.example.persistance;

import org.example.data.Department;
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
public class InMemoryDepartmentPersistanceTest {
    @InjectMocks
    private InMemoryDepartmentPersistance inMemoryDepartmentPersistance;

    @Mock
    private List<Department> departments;

    @BeforeEach
    public void setUp() {
        inMemoryDepartmentPersistance = new InMemoryDepartmentPersistance();
        this.departments = new ArrayList<>();
    }

    @Test
    public void addNewDepartment_ToPersistence_Succeeds() {
        Department department2 = new Department(1000, "Technology", 100000);
        inMemoryDepartmentPersistance.addDepartment(department2);
        List<Department> departmentList = inMemoryDepartmentPersistance.getDepartments();
        Assertions.assertTrue(departmentList.contains(department2));
    }
    @Test
    public void addNewDepartment_ToPersistence_Fails() {
        Department department2 = new Department(1000, "Technology", 100000);
        departments.add(department2);
        inMemoryDepartmentPersistance.addDepartment(department2);
        Assertions.assertFalse(departments.contains(department2));
    }

    @Test
    public void removeDepartment_FromPersistence() {
        Department department2 = new Department(1000, "Technology", 100000);
        departments.add(department2);
        inMemoryDepartmentPersistance.removeDepartmentBy(department2.getDepartmentId());
        Assertions.assertFalse(departments.contains(department2));
    }

    @Test
    public void updateDepartment() {
        Department department1 = new Department(1000, "Technology", 100000);
        Department department2 = new Department(1000, "Technology2", 1000002);
        departments.add(department1);
        inMemoryDepartmentPersistance.updateDepartment(department2);
        Assertions.assertFalse(departments.contains(department1));
    }
}


