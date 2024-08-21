package stream.api2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,9,3,6,4,5,1,9);
        int target = 10;

        Set<List<Integer>> uniquePairs = numbers.stream()
            .flatMap(num1 -> numbers.stream()
                .filter(num2 -> num1 + num2 == target && num1 < num2)
                .map(num2 -> Arrays.asList(num1, num2))
            ).collect(Collectors.toSet());

        System.out.println(uniquePairs);

        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Турция", "Анкара");
        countryCapital.put("Нидерланды", "Амстердам");
        countryCapital.put("Сербия", "Белград");
        countryCapital.put("Украина", "Киев");

        List<String> capitals = countryCapital.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(Map.Entry::getValue)
            .toList();

        System.out.println(capitals);

        List<String> countries = countryCapital.values().stream().toList();
        char targetChar = 'A';

        List<String> result = countries.stream()
            .filter(c -> c.startsWith(String.valueOf(targetChar)))
            .sorted(Comparator.comparingInt(String::length))
            .toList();

        System.out.println(result);

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Алиса", Arrays.asList("Борис", "Женя", "Давид"));
        friendsMap.put("Борис", Arrays.asList("Алиса", "Женя"));
        friendsMap.put("Женя", Arrays.asList("Борис", "Ева"));
        friendsMap.put("Давид", List.of("Алиса"));
        friendsMap.put("Ева", List.of("Женя"));

        List<String> nonFriendPairs = friendsMap.keySet().stream()
                .flatMap(people1 -> friendsMap.keySet().stream()
                        .filter(people2 -> !people1.equals(people2))
                        .filter(people2 -> !friendsMap.get(people1).contains(people2))
                        .filter(people2 -> {
                            Set<String> commonFriends = new HashSet<>(friendsMap.get(people1));
                            commonFriends.retainAll(friendsMap.get(people2));

                            return !commonFriends.isEmpty();
                        }).map(people2 -> people1 + " - " + people2)
                )
                .toList();

        nonFriendPairs.forEach(System.out::println);

        List<Employee> employees = Arrays.asList(
            new Employee("Алиса", 50000, "IT"),
            new Employee("Борис", 60000, "HR"),
            new Employee("Женя", 70000, "HR"),
            new Employee("Дамид", 55000, "IT"),
            new Employee("Ева", 65000, "QA")
        );

        Map<String, Double> avgSalariesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        avgSalariesByDepartment.forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));


        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "fish", "giraffe", "кот");
        List<Character> alphabet = Arrays.asList('a', 'e', 'i', 'o', 'u', 'p', 'l', 't', 'f', 'h', 's', 'g', 'r');

        List<String> filteredAndSortedStrings = strings.stream()
            .filter(s -> s.chars().allMatch(c -> alphabet.contains((char) c)))
            .sorted(Comparator.comparingInt(String::length))
            .toList();

        filteredAndSortedStrings.forEach(System.out::println);


        List<String> resultStrings = convertToStrings(numbers);
        resultStrings.forEach(System.out::println);

        List<Integer> palindromes = findPalindromesInRange(10, 150);
        palindromes.forEach(System.out::println);
    }

    public static List<String> convertToStrings(List<Integer> numbers) {
        return numbers.stream()
            .map(Integer::toBinaryString)
            .toList();
    }

    public static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter((number -> {
                    String str = Integer.toString(number);
                    String reversedStr = new StringBuilder(str).reverse().toString();
                    return str.equals(reversedStr);
                }))
                .boxed()
                .toList();
    }
}
