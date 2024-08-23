package faang.school.godbless.BJS2_22461;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPracticeII {
    public static List<List<Integer>> findUniquePairs(List<Integer> integers, int targetSum) {
        Set<Integer> seenNumbers = new HashSet<>();
        Set<List<Integer>> pairs = new HashSet<>();

        integers.forEach(number -> {
            int complement = targetSum - number;
            if (seenNumbers.contains(complement)) {
                List<Integer> pair = List.of(Math.min(number, complement), Math.max(number, complement));
                pairs.add(pair);
            }
            seenNumbers.add(number);
        });

        return pairs.stream().toList();
    }

    public static List<String> sortCapitals(Map<String, String> countryCapitals) {
        var capitals = countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

        capitals.forEach(System.out::println);
        return capitals;
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startWith) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startWith)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findUniqueFriendPairs(Map<String, List<String>> friendships) {
        return friendships.keySet().stream()
                .flatMap(person1 -> friendships.keySet().stream()
                        .filter(person2 -> !person1.equals(person2) &&
                                           !friendships.get(person1).contains(person2) &&
                                           friendships.get(person1).stream()
                                                   .anyMatch(friendships.get(person2)::contains))
                        .map(person2 -> Set.of(person1, person2))
                )
                .collect(Collectors.toSet()).stream()
                .map(set -> set.stream().toList())
                .toList();
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, char[] alphabet) {
        Set<Character> allowedChars = new HashSet<>();
        for (char c : alphabet)
            allowedChars.add(c);

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(n -> {
                    String s = String.valueOf(n);
                    return s.contentEquals(new StringBuilder(s).reverse().toString());
                })
                .boxed()
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String input) {
        return Arrays.stream(input.toLowerCase().split(" ")).
                filter(s -> s.contentEquals(new StringBuilder(s).reverse().toString()))
                .toList();
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(n -> IntStream.range(1, n)
                        .filter(i -> n % i == 0)
                        .sum() == n)
                .boxed()
                .toList();
    }
}