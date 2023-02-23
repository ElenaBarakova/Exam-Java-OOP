package org.example.service.promotion;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.persistance.DepartmentPersistance;

public class PromotioncalulatorImpl implements PromotionCalculator {
    private final DepartmentPersistance departmentPersistance;

    public PromotioncalulatorImpl(DepartmentPersistance departmentPersistance) {
        this.departmentPersistance = departmentPersistance;
    }

    @Override
    public double increaseSalary(Employee employee, double percentage) {
        if (percentage < 0) {
            System.out.println("The promotion percentage needs to be a positive floating number!");
        }
        double newSalary = employee.getYearlySalary() * (1 + percentage / 100);
        if (employee.getEmployeeDepartmentName().equals("N/A")){
            employee.setYearlySalary(newSalary);
        }else{
            Department department = departmentPersistance.getDepartmentBy(employee.getEmployeeDepartmentName());
            if (department.getLeftOverBudget()-newSalary<0){
                System.out.println("Department "+department.getDepartmentId()+"’s budget does not allow for such a high promotion!");
            }
            employee.setYearlySalary(newSalary);
        }
        return newSalary;

    }
}
