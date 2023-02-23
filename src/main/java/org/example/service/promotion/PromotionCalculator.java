package org.example.service.promotion;

import org.example.data.Employee;

public interface PromotionCalculator {
    double increaseSalary(Employee employee, double percentage);
}
