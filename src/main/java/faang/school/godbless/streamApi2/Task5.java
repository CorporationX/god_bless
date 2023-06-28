package faang.school.godbless.streamApi2;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
 * Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
 */
public class Task5 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Ivan", 50000, "Marketing"),
                new Employee("Petr", 45000, "Marketing"),
                new Employee("Sergey", 55000, "Development"),
                new Employee("Julia", 58000, "Development"),
                new Employee("Egor", 300000, "SEO")
        );

        Map<String, Double> collected = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(collected);
    }
}
