package faang.school.godbless.BJS2_838;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers2 = List.of(3, 5, 2, 1, 7, 5, 8);
        Set<List<Integer>> foundPairs2 = findPairs(numbers2, 10);
        System.out.println("Pairs of integers: " + foundPairs2);

        Map<String, String> citiesAndCapitals = new HashMap<>(Map.of(
                "England", "London",
                "Russia", "Moscow",
                "United States", "Washington",
                "France", "Paris"
        ));
        System.out.println("Sorted list of countries and its capitals: ");
        printSortedCapitalsByCities(citiesAndCapitals);

        List<String> inputStrings = Arrays.asList("apple", "banana", "orange", "avocado", "blueberry", "pear");
        char targetLetter = 'a';
        System.out.println("Starts with letter and sorted by length: " + startsWithLetterAndSortByLength(inputStrings, targetLetter));

        Map<String, List<String>> friendsMap = Map.of(
                "Alice", Arrays.asList("Bob", "Charlie", "David"),
                "Bob", Arrays.asList("Alice", "Eve"),
                "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Alice", "Charlie"),
                "Eve", Arrays.asList("Bob")
        );
        List<List<String>> pairsWithCommonFriends = findPairsWithCommonFriends(friendsMap);
        System.out.println(pairsWithCommonFriends);

        List<Employee> employees = List.of(
                new Employee("Eda", 1000, "IT"),
                new Employee("Dima", 21000, "HR"),
                new Employee("Abdul", 14000, "IT"),
                new Employee("Imran", 11000, "Art")
        );
        System.out.println("Average salary by department: " + averageSalaryByDep(employees));

        List<String> strings = Arrays.asList("some", "worm", "storm", "born");
        char[] allowedAlphabet = "swrome".toCharArray();
        System.out.println("Filtered by alphabet: " + filterByAlphabet(strings, allowedAlphabet));

        List<Integer> numbers = List.of(10, 20, 30, 40);
        System.out.println("Binary representations: " + toBinary(numbers));

        System.out.println("Palindromic numbers: " + findAllPalindromes(10, 100));

        String input = "abba";
        List<String> palindromicSubstrings = findAllPalindromeSubstrings(input);
        System.out.println("Palindromic Substrings: " + palindromicSubstrings);

        System.out.println("Perfect numbers: " + findAllPerfectNumbers(0, 100));
    }


    public static Set<List<Integer>> findPairs(List<Integer> numbers, int target) {
        Set<List<Integer>> result = new HashSet<>();

        numbers.stream()
                .filter(num -> numbers.contains(target - num))
                .forEach(num -> result.add(Stream.of(num, target - num).sorted().toList()));
        return result;
    }

    public static void printSortedCapitalsByCities(Map<String, String> cityAndCapitals) {
        List<Map.Entry<String, String>> entries = cityAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).toList();
        System.out.println(entries);
    }

    public static List<String> startsWithLetterAndSortByLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findPairsWithCommonFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(entry1 ->
                        friends.entrySet().stream()
                                .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                                .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                                .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                                .map(entry2 -> {
                                    List<String> pair = new ArrayList<>(List.of(entry1.getKey(), entry2.getKey()));
                                    pair.sort(Comparator.naturalOrder()); // Сортировка имен в паре
                                    return pair;
                                })
                )
                .distinct()
                .toList();
    }

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

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findAllPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .filter(num -> Integer.toString(num).equals(new StringBuilder(Integer.toString(num)).reverse().toString()))
                .boxed().toList();
    }

    public static List<String> findAllPalindromeSubstrings(String string) {
        return IntStream.rangeClosed(0, string.length() - 1)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, string.length())
                        .filter(j -> string.substring(i, j).equals(new StringBuilder(string.substring(i, j)).reverse().toString()))
                        .mapToObj(j -> string.substring(i, j))
                ).toList();
    }

    public static List<Integer> findAllPerfectNumbers(int start, int end) {
        if (start <= 1) {
            start = 2;
        }
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    int sum = IntStream.range(1, num)
                            .filter(i -> num % i == 0).sum();
                    return sum == num;
                }).boxed().toList();
    }
}