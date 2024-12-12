package school.faang.task47220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.task47220.Department.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friends = new HashMap<>(
                Map.of(
                        "Alice", List.of("Bob", "Charlie"),
                        "Bob", List.of("Alice", "David"),
                        "Charlie", List.of("Alice", "David"),
                        "David", List.of("Bob", "Charlie")
                ));

        Task.coupleCommonFriends(friends).forEach(list -> System.out.printf("%s ", list));
        System.out.println();
        Task.palindromeNumbers(-100, 2000).forEach(number -> System.out.printf("%s ", number));
        System.out.println();
        Task.palindromeSubstring("abacded").forEach(substring -> System.out.printf("%s ", substring));
        System.out.println();

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Sergey", 25000, IT_DEPARTMENT),
                new Employee("Alexey", 30000, IT_DEPARTMENT),
                new Employee("Kirill", 40000, IT_DEPARTMENT),
                new Employee("Nastya", 20000, SALES_DEPARTMENT),
                new Employee("Masha", 22000, SALES_DEPARTMENT),
                new Employee("Anna", 28000, SALES_DEPARTMENT)
        ));

        Task.averageSalary(employees)
                .forEach((key, value) -> System.out.printf("[%s зарплата: %.0f] ", key.getName(), value));

        System.out.println();
        Task.perfectNumbers(1, 10000).forEach(number -> System.out.printf("%d ", number));


    }
}
