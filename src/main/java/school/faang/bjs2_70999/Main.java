package school.faang.bjs2_70999;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> users = Map.of(
            "Alice", List.of("Bob", "Charlie"),
            "Bob", List.of("Alice", "Dave"),
            "Charlie", List.of("Alice", "Dave"),
            "Dave", List.of("Bob", "Charlie")
        );
        log.info("Potential friends {}.", Processor.findMutualFriends(users));

        List<Employee> employes = List.of(
            new Employee("Alice", "Finance", 10_001),
            new Employee("Bob", "IT", 15_050),
            new Employee("Charlie", "IT", 20_000),
            new Employee("Dave", "Finance", 12_300),
            new Employee("Eve", "Logistics", 18_000),
            new Employee("Frank", "IT", 22_000)
        );
        log.info("Average salare per departmetn {}.", Processor.getAvgSalaryByDpt(employes));

        int start = 100;
        int end = 200;
        log.info("Palindromic numbers {}.", Processor.findPalindromicNumsInRange(start, end));

        String str = "abac";
        log.info("Palindromic strings {}.", Processor.findPalindromicStrings(str));

        int newStart = 1;
        int newEnd = 1_000;
        log.info("Perfect numbres {}.", Processor.findPerfectNumbersInRange(newStart, newEnd));
    }
}
