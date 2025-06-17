package school.faang.module1.bjs2_80802;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Map<String, List<String>> friendsMap = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        log.info("{}", Operations.findPeopleWithCommonFriends(friendsMap));

        List<Employee> employees = List.of(
                new Employee("Bob", 5000, "IT"),
                new Employee("Alice", 7000, "IT"),
                new Employee("Charlie", 4500, "HR"),
                new Employee("David", 6000, "HR"),
                new Employee("Adam", 4000, "Sales")
        );
        log.info("{}", Operations.averageSalaryByDepartment(employees));

        int palindromesStart = 100;
        int palindromesEnd = 200;
        log.info("{}", Operations.findPalindromes(palindromesStart, palindromesEnd));

        String inputString = "abac";
        log.info("{}", Operations.findPalindromicSubstrings(inputString));

        int perfectStart = 1;
        int perfectEnd = 1000;
        log.info("{}", Operations.findPerfectNumbers(perfectStart, perfectEnd));
    }
}