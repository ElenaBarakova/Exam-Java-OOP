package org.example;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.persistance.InMemoryDepartmentPersistance;
import org.example.persistance.InMemoryEmployeePersistance;
import org.example.presentation.ConsoleDepartmentPresenter;
import org.example.presentation.ConsoleEmployeePresenter;
import org.example.service.*;
import org.example.service.promotion.PromotionCalculatorImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final InMemoryEmployeePersistance inMemoryEmployeePersistance = new InMemoryEmployeePersistance();
        final InMemoryDepartmentPersistance inMemoryDepartmentPersistance = new InMemoryDepartmentPersistance();


        DepartmentService departmentService = new DepartmentServiceImpl(inMemoryDepartmentPersistance,
                inMemoryEmployeePersistance, new ConsoleDepartmentPresenter());
        EmployeeService employeeService = new EmployeeServiceImpl(inMemoryEmployeePersistance,
                new PromotionCalculatorImpl(inMemoryDepartmentPersistance), new ConsoleEmployeePresenter());


        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            if (command.equals("CreateDepartment")) {
                int departmentId = Integer.parseInt(tokens[1]);
                String departmentName = tokens[2];
                int yearlyBudget = Integer.parseInt(tokens[3]);
                Department department = new Department(departmentId, departmentName, yearlyBudget);
                departmentService.addDepartment(department);
            } else if (command.equals("HireEmployee")) {
                int employeeId = Integer.parseInt(tokens[1]);
                String firstName = tokens[2];
                String lastName = tokens[3];
                double yearlySalary = Integer.parseInt(tokens[4]);
                Employee employee = new Employee(employeeId, firstName, lastName, yearlySalary);
                employeeService.hireEmployee(employee, employeeId);
            } else if (command.equals("AssignDepartment")) {
                int employeeId = Integer.parseInt(tokens[1]);
                int departmentId = Integer.parseInt(tokens[2]);
                departmentService.assignEmployeeToDepartment(employeeId, departmentId);
            } else if (command.equals("PromoteEmployee")) {
                int employeeId = Integer.parseInt(tokens[1]);
                double promotionPercentage = Double.parseDouble(tokens[2]);
                employeeService.promoteEmployee(employeeId, promotionPercentage);

            } else if (command.equals("ShowEmployee")) {
                int employeeId = Integer.parseInt(tokens[1]);
                employeeService.showEmployee(employeeId);
            } else if (command.equals("ShowDepartment")) {
                int departmentId = Integer.parseInt(tokens[1]);
                departmentService.showDepartment(departmentId);
            } else if (command.equals("UpdateDepartment")) {
                int departmentId = Integer.parseInt(tokens[1]);
                String departmentName = tokens[2];
                int yearlyBudget = Integer.parseInt(tokens[3]);
                Department department = new Department(departmentId, departmentName, yearlyBudget);
                departmentService.updateDepartment(department);
            }

            line = scanner.nextLine();
        }

    }
}
