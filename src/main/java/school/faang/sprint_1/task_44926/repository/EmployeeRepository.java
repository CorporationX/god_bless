package school.faang.sprint_1.task_44926.repository;

import school.faang.sprint_1.task_44926.entity.Employee;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class EmployeeRepository {
    private static final Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Set<Employee> getAllEmployees() {
        return Set.copyOf(employees);
    }
}
