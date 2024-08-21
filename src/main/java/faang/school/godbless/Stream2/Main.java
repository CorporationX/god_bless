package faang.school.godbless.Stream2;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5, 5);
        int targetSum = 10;
        findPairsWithSum(numbers, targetSum);


        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("France", "Paris"); //1
        countryCapitalMap.put("Spain", "Madrid"); //4
        countryCapitalMap.put("Italy", "Rome"); //3
        countryCapitalMap.put("Germany", "Berlin"); //2
        sortedCapitalByCountry(countryCapitalMap);


        List<String> strings = Arrays.asList("apple", "apricot", "banana", "avocado", "pear", "pineapple");
        char filterChar = 'a';
        filterAndSortStrings(strings, filterChar);


        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "David"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David", "Alice", "Charlie"));
        friendsMap.put("Charlie", Arrays.asList("Bob", "David"));
        findNonFriendPairsWithCommonFriends(friendsMap);  // элис и чарли не дружат но знают боба

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 70000, "IT"),
                new Employee("David", 55000, "HR"),
                new Employee("Eve", 80000, "Finance"),
                new Employee("Frank", 90000, "Finance")
        );
        calculateAverageSalaryByDepartment(employees);


        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        filterAlphabetAndSortStrings(inputStrings, alphabet);


        convertToBinaryStrings(Arrays.asList(1, 2, 3, 4, 5));

        findPalindromicNumbers(10, 1000);

        findPalindromicInString("Moloko");

        findPerfectNumbersInRange(5, 497);
    }

    private static void findPerfectNumbersInRange(int i, int j) {
        System.out.println(
                IntStream.rangeClosed(i, j)
                        .filter(num -> num == IntStream.range(1, num)
                                .filter(divisor -> num % divisor == 0)
                                .sum())
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    private static void findPalindromicInString(String string) {
        int lengthString = string.length();
        System.out.println(
                IntStream.range(0, lengthString)
                        .boxed()
                        .flatMap(start -> IntStream.range(start + 1, lengthString + 1)
                                .mapToObj(end -> string.substring(start, end))
                        ).filter(str -> str.contentEquals(new StringBuilder(str).reverse()) && str.length() > 1)
                        .distinct()
                        .toList()
        );
    }

    private static void findPalindromicNumbers(int i, int j) {
        System.out.println(
                IntStream.range(i, j)
                        .mapToObj(Integer::toString)
                        .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                        .toList()
        );
    }

    private static void convertToBinaryStrings(List<Integer> list) {
        System.out.println(
                list.stream()
                        .map(Integer::toBinaryString)
                        .toList()
        );
    }

    private static void filterAlphabetAndSortStrings(List<String> inputStrings, String alphabet) {
        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        System.out.println(
                inputStrings.stream()
                        .filter(str -> str.chars()
                                .allMatch(c -> allowedChars.contains((char) c)))
                        .sorted(Comparator.comparing(String::length))
                        .toList()
        );
    }

    private static void calculateAverageSalaryByDepartment(List<Employee> employees) {
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.averagingDouble(Employee::getSalary)
                                )
                        )
        );
    }

    private static void findNonFriendPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        int mapSize = friendsMap.size();
        System.out.println(
                IntStream.range(0, mapSize)
                        .mapToObj(i -> friendsMap.keySet()
                                .stream()
                                .toList()
                                .subList(i, mapSize))
                        .flatMap(sublist -> sublist.stream()
                                .skip(1)
                                .filter(friend -> !friendsMap.get(sublist.get(0)).contains(friend))
                                .map(friend -> Arrays.asList(sublist.get(0), friend))
                        ).toList()
        );
    }

    public static void findPairsWithSum(@NonNull List<Integer> list, int sumCompared) {
        IntStream.range(0, list.size())
                .mapToObj(i -> list.subList(i, list.size()))
                .flatMap(sublist -> sublist.stream()
                        .skip(1)
                        .filter(j -> sublist.get(0) + j == sumCompared)
                        .map(j -> Arrays.asList(sublist.get(0), j))
                )
                .forEach(System.out::println);
    }

    public static void sortedCapitalByCountry(@NonNull Map<String, String> countryCapitalMap) {
        System.out.println(
                countryCapitalMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue).toList()
        );
    }


    public static void filterAndSortStrings(List<String> strings, char filterChar) {
        System.out.println(
                strings.stream()
                        .filter(word -> word.charAt(0) == filterChar)
                        .sorted(Comparator.comparing(String::length))
                        .toList()
        );
    }
}
