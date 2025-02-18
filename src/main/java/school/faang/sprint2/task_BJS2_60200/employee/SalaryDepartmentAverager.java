package school.faang.sprint2.task_BJS2_60200.employee;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SalaryDepartmentAverager {
    private final Map<Department, Pair> departmentData = new HashMap<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            return;
        }
        departmentData.computeIfAbsent(employee.getDepartment(), k -> new Pair());
        departmentData.get(employee.getDepartment()).add(employee.getSalary());
    }

    public Map<Department, Double> getAverageSalaryOfDepartments() {
        return departmentData.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getAverage()));
    }

    private class Pair {
        private int sumOfSalary;
        private int count;

        private void add(int salary) {
            sumOfSalary += salary;
            count++;
        }

        private double getAverage() {
            return (double) sumOfSalary / count;
        }
    }
}
