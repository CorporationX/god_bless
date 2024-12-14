package faang.school.godbless.secondsprint.exercisingstream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int targetSum) {
        Set<Integer> seen = new HashSet<>();

        return numbers.stream()
                .filter(num -> {
                    int complement = targetSum - num;
                    boolean isPairFound = seen.contains(complement);
                    seen.add(num);
                    return isPairFound;
                })
                .map(num -> Arrays.asList(Math.min(num, targetSum - num), Math.max(num, targetSum - num)))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startingLetter) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == startingLetter)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Set<List<String>> findNonFriendsWithCommonFriends(Map<String, List<String>> usersFriends) {
        return usersFriends.entrySet().stream()
                .flatMap(entry -> {
                    String person = entry.getKey();
                    Set<String> friends = new HashSet<>(entry.getValue());

                    return usersFriends.entrySet().stream()
                            .filter(e -> !e.getKey().equals(person))
                            .filter(e -> !Collections.disjoint(friends, e.getValue()))
                            .filter(e -> !e.getValue().contains(person))
                            .map(e -> {
                                List<String> pair = Arrays.asList(person, e.getKey());
                                Collections.sort(pair);
                                return pair;
                            });
                })
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        Set<Character> allowedChars = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .filter(Utils::isIntPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isIntPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static List<String> findPalindromicSubstrings(String input) {
        String sanitizedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        return IntStream.range(0, sanitizedInput.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, sanitizedInput.length() + 1)
                        .mapToObj(j -> sanitizedInput.substring(i, j)))
                .filter(str -> str.length() > 1 && isStringPalindrome(str)).distinct().collect(Collectors.toList());
    }

    private static boolean isStringPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(Utils::isPerfectNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPerfectNumber(int number) {
        if (number < 2) return false;

        int sum = IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .flatMap(i -> {
                    if (i == number / i) {
                        return IntStream.of(i);
                    } else {
                        return IntStream.of(i, number / i);
                    }
                })
                .filter(divisor -> divisor < number)
                .sum();

        return sum == number;
    }

    @Getter
    @AllArgsConstructor
    static class Employee {
        private String name;
        private String department;
        private double salary;
    }
}
