package faang.school.godbless.stream_api_part_two;

import java.util.List;
import java.util.Map;

public class Main {
    private final static List<Integer> NUMBERS = List.of(1, 9, 6, 5, 3, 5, 4, 5, 5);
    private final static Map<String, String> COUNTRIES = Map.of(
            "Russia", "Moscow",
            "France", "Paris",
            "USA", "Washington",
            "China", "Beijing",
            "Germany", "Berlin"
    );
    private final static List<String> STRINGS = List.of(
            "Hello",
            "What is your name?",
            "Just do it",
            "You are welcome",
            "Hi",
            "How are you?",
            "What are you doing?"
    );
    private final static Map<String, List<String>> PERSON_FRIENDS = Map.of(
            "Vladimir", List.of("Anton", "Vlad", "Andrei"),
            "Alexandr", List.of("Andrei"),
            "Vlad", List.of("Vladimir", "Anton", "Alexandr"),
            "Anton", List.of("Vladimir", "Vlad"),
            "Andrei", List.of("Vladimir", "Alexandr")
    );

    private final static List<Employee> EMPLOYEES = List.of(
            new Employee("Kirk Dunkan", 1000.0, "Sales"),
            new Employee("Maikl Hembon", 1350.0, "Logistics"),
            new Employee("Kira Naithli", 1456.0, "Finance"),
            new Employee("Big Maik", 2600.5, "Sales"),
            new Employee("Hilary Maknil", 960.8, "Sales"),
            new Employee("Robert Patricson", 2200.0, "Finance"),
            new Employee("Natali Portman", 1500.5, "Finance")
    );

    private final static List<String> DIFFERENT_STRING = List.of("apple", "banana", "123", "dog", "cat");
    private final static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        System.out.println(StreamUtils.findUniquePairs(NUMBERS, 10));
        System.out.println(StreamUtils.sortedMapAndShowCapitals(COUNTRIES));
        System.out.println(StreamUtils.filteredStringSortedStringByChar(STRINGS, 'H'));
        System.out.println(StreamUtils.findPeopleNonFriends(PERSON_FRIENDS));
        System.out.println(StreamUtils.getDepartmentAverageSalary(EMPLOYEES));
        System.out.println(StreamUtils.filterAndSortStringsByAlphabet(DIFFERENT_STRING, ALPHABET));
        System.out.println(StreamUtils.numsToBinaryStrings(NUMBERS));
        System.out.println(StreamUtils.findPalindromes(1, 220));
    }
}
