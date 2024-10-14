package school.faang.stream_api3_BJS2_34812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamProcessor processor = new StreamProcessor();

        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Alice Johnson", 75000, "Engineering")
                , new Employee("Bob Smith", 62000, "Marketing")
                , new Employee("Charlie Brown", 85000, "Finance")
                , new Employee("Diana Ross", 78000, "Human Resources")
                , new Employee("Ethan White", 91000, "Sales")
                , new Employee("Fiona Green", 82000, "Engineering")
                , new Employee("George Black", 67000, "Marketing")
        ));

        Map<String, List<String>> friends = new HashMap<>(Map.of(
                "Alice", new ArrayList<>(List.of("Bob", "Charlie"))
                , "Bob", new ArrayList<>(List.of("Alice", "David"))
                , "Charlie", new ArrayList<>(List.of("Alice", "David"))
                , "David", new ArrayList<>(List.of("Bob", "Charlie"))));

        int listFrom = 1;
        int listTo = 200;

        processor.findCommonFriends(friends)
                .forEach((list) -> System.out.println(Arrays.toString(list)));
        System.out.println(processor.findAverageSalary(employees));
        System.out.println(processor.findNumPalindromes(listFrom, listTo));
        System.out.println(processor.findStringPalindromes("abac"));
        System.out.println(processor.findPerfectNumbers(listFrom, listTo));
    }
}
