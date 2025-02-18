package school.faang.sprint2.task_BJS2_60200.employee;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Employee {
    private static int idGenerator;
    private int id;
    private String name;
    private int salary;
    private Department department;

    public Employee(String name, int salary, Department department) {
        validName(name);
        validSalary(salary);
        validDepartment(department);

        id = idGenerator++;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    private void validName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Не валидное имя: " + name);
        }
    }

    private void validSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Не валидная зарплата: " + salary);
        }
    }

    private void validDepartment(Department department) {
        if (Objects.isNull(department)) {
            throw new IllegalArgumentException("Не валидный отдел: " + department);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
