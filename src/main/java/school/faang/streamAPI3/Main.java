package school.faang.streamAPI3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", List.of("Bob", "Charlie"));
        friendsMap.put("Bob", List.of("Alice", "David"));
        friendsMap.put("Charlie", List.of("Alice", "David"));
        friendsMap.put("David", List.of("Bob", "Charlie"));
        Employee employee1 = new Employee("Noob", 10000, "Department1");
        Employee employee2 = new Employee("CoolDude", 30000, "Department1");
        Employee employee3 = new Employee("MadMouse", 5000, "Department1");
        Employee employee4 = new Employee("Moderator", 1000000, "Department2");
        Employee employee5 = new Employee("Notch", 3000, "Department2");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);


        System.out.println(SpecialOperations.findMutual(friendsMap));
        System.out.println(SpecialOperations.findAverageSalary(employees));
        System.out.println(SpecialOperations.findPolindromeNumbers(101, 202));
        System.out.println(SpecialOperations.findPolindromeStrings("abac"));
        System.out.println(SpecialOperations.findPerfectNumbers(1, 10000));
    }
}