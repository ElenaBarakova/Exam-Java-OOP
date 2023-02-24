package org.example.service;

import org.example.data.Employee;
import org.example.persistance.EmployeePersistance;
import org.example.presentation.EmployeePresenter;
import org.example.service.promotion.PromotionCalculator;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeePersistance employeePersistance;
    private final PromotionCalculator promotionCalculator;
    private final EmployeePresenter employeePresenter;

    public EmployeeServiceImpl(EmployeePersistance employeePersistance, PromotionCalculator promotionCalculator, EmployeePresenter employeePresenter) {
        this.employeePersistance = employeePersistance;
        this.promotionCalculator = promotionCalculator;
        this.employeePresenter = employeePresenter;
    }

    @Override
    public void hireEmployee(Employee employee, int employeeId) {
        employeePersistance.addEmployee(employee, employeeId);

    }

    @Override
    public void promoteEmployee(int employeeId, double percentage) {
        Employee employee = employeePersistance.getEmployeeBy(employeeId);
        double increasedSalary = promotionCalculator.increaseSalary(employee, percentage);
        employeePersistance.updateEmployee(employee);
    }

    @Override
    public void showEmployee(int employeeId) {
        Employee employee = employeePersistance.getEmployeeBy(employeeId);
        if (employee==null){
            System.out.println("Employee with ID " + employeeId + " does not exist!");
        }else{
            employeePresenter.displayEmployee(employee);
        }

    }
}
