package faang.school.godbless.stream_api_parttwo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamService {
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
        System.out.println(findUniquePairs(NUMBERS, 10));
        System.out.println(sortedMapAndShowCapitals(COUNTRIES));
        System.out.println(filteredStringSortedStringByChar(STRINGS, 'H'));
        System.out.println(findPeopleNonFriends(PERSON_FRIENDS));
        System.out.println(getDepartmentAverageSalary(EMPLOYEES));
        System.out.println(filterAndSortStringsByAlphabet(DIFFERENT_STRING, ALPHABET));
    }

    public static List<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        if (numbers.isEmpty() || numbers == null) {
            throw new IllegalArgumentException("Numbers shouldn't be empty or null");
        }
        return numbers.stream().filter(num -> num < sum)
                .flatMap(numOne -> numbers.stream()
                        .filter(numTwo -> numOne + numTwo == sum)
                        .map(numTwo -> List.of(numOne, numTwo).stream().sorted().toList()))
                .distinct().collect(Collectors.toList());
    }

    public static List<String> sortedMapAndShowCapitals(Map<String, String> countries) {
        if (countries.isEmpty()) {
            throw new IllegalArgumentException("Countries shouldn't be empty");
        }
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filteredStringSortedStringByChar(List<String> strings, char checkChar) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Strings shouldn't be empty");
        }
        return strings.stream().filter(str -> str.charAt(0) == checkChar).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<List<String>> findPeopleNonFriends(Map<String, List<String>> personFriends) {
        if (personFriends.isEmpty()) {
            throw new IllegalArgumentException("userFriends shouldn't be empty");
        }
        return personFriends.entrySet().stream()
                .flatMap(entryOne -> personFriends.entrySet().stream()
                        .filter(entryTwo -> !entryTwo.getKey().equals(entryOne.getKey()) && !entryOne.getValue().contains(entryTwo.getKey()))
                        .filter(entryTwo -> entryTwo.getValue().stream().anyMatch(name -> entryOne.getValue().contains(name)))
                        .map((person) -> List.of(entryOne.getKey(), person.getKey()).stream().sorted().toList())).distinct().toList();
    }

    public static Map<String, Double> getDepartmentAverageSalary(List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("employees shouldn't be empty");
        }
        return employees.stream().collect(Collectors.groupingBy(
                Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<String> filterAndSortStringsByAlphabet(List<String> strings, char[] alphabet) {
        if (strings.isEmpty() || alphabet.length == 0) {
            throw new IllegalArgumentException("arguments shouldn't be empty");
        }


        Set<Character> alphabetSet = Arrays.st.collect(Collectors.toSet());
        return strings.stream().filter(str -> str.chars().anyMatch(character -> alphabetSet.contains(character)))
                .sorted(Comparator.comparingInt(String::length)).toList();

    }
}

