package school.faang.stream2.streamapi3;

import java.util.List;
import java.util.Map;

import static school.faang.stream2.streamapi3.Util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> socium = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        System.out.println(findNoFriendsWithCommon(socium));

        List<Employee> employees = List.of(
                new Employee("Alice", 75000, "IT"),
                new Employee("Bob", 68000, "IT"),
                new Employee("Charlie", 71000, "IT"),
                new Employee("Diana", 65000, "HR"),
                new Employee("Evan", 66000, "HR"),
                new Employee("Fiona", 72000, "Sales"),
                new Employee("George", 69000, "Sales"),
                new Employee("Helen", 73000, "Sales"),
                new Employee("Ian", 76000, "Sales"),
                new Employee("Jack", 64000, "Marketing"),
                new Employee("Karen", 67000, "Marketing"),
                new Employee("Leo", 62000, "Marketing"),
                new Employee("Mona", 63000, "Marketing"),
                new Employee("Nina", 78000, "IT"),
                new Employee("Oscar", 70000, "HR")
        );
        System.out.println(findAverageSalaryByDepartment(employees));

        System.out.println(findAllPalindromsInRange(-64, 1920));

        System.out.println(findAllPalindromsInString("deifiedrotatorevelevelcivic"));

        System.out.println(findAllPerfectNumbersInRange(1, 1000));
    }
}
