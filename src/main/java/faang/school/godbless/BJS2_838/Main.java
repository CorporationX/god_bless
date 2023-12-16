package faang.school.godbless.BJS2_838;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(3, 2, 3, 2, 5, 0, 2, 3, 2, 3);
        Set<List<Integer>> foundPairs1 = findPairs(numbers1, 5);
        System.out.println(foundPairs1);

        List<Integer> numbers2 = List.of(3, 5, 2, 1, 7, 5, 8);
        Set<List<Integer>> foundPairs2 = findPairs(numbers2, 10);
        System.out.println(foundPairs2);

        Map<String, String> citiesAndCapitals = new HashMap<>(Map.of(
                "England", "London",
                "Russia", "Moscow",
                "United States", "Washington",
                "France", "Paris"
        ));
        printSortedCapitalsByCities(citiesAndCapitals);

        List<String> inputStrings = Arrays.asList("apple", "banana", "orange", "avocado", "blueberry", "pear");
        char targetLetter = 'a';
        System.out.println(filterAndSortByLength(inputStrings, targetLetter));

        Map<String, List<String>> friendsMap = Map.of(
                "Alice", Arrays.asList("Bob", "Charlie", "David"),
                "Bob", Arrays.asList("Alice", "Eve"),
                "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Alice", "Charlie"),
                "Eve", Arrays.asList("Bob")
        );
        List<List<String>> pairsWithCommonFriends = findPairsWithCommonFriends(friendsMap);

        List<Employee> employees = List.of(
                new Employee("Eda", 1000, "IT"),
                new Employee("Dima", 21000, "HR"),
                new Employee("Abdul", 14000, "IT"),
                new Employee("Imran", 11000, "Art")
        );
        System.out.println(averageSalaryByDep(employees));

        List<String> strings = Arrays.asList("some", "worm", "storm", "born");
        char[] allowedAlphabet = "swrome".toCharArray();
        System.out.println(filterByAlphabet(strings, allowedAlphabet));
    }


    public static Set<List<Integer>> findPairs(List<Integer> numbers, int target) {
        Set<List<Integer>> result = new HashSet<>();

        numbers.stream()
                .filter(num -> numbers.contains(target - num))
                .forEach(num -> result.add(Stream.of(num, target - num).sorted().toList()));
        return result;
    }

    public static void printSortedCapitalsByCities(Map<String, String> cityAndCapitals) {
        cityAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

    public static List<String> filterAndSortByLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public static List<List<String>> findPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        Stream<Map.Entry<String, List<String>>> entryStream;

        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////

    public static Map<String, Double> averageSalaryByDep(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingInt(Employee::getSalary)
        ));
    }

    public static List<String> filterByAlphabet(List<String> strings, char... alphabet) {
        Arrays.sort(alphabet);
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> Arrays.binarySearch(alphabet, (char) c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}