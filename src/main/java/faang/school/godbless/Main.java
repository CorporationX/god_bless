package src.main.java.faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(numbers -> numbers % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(naturalOrder())
                .get();
    }

    public static OptionalDouble calculateAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long countStartsWithJ(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("J"))
                .count();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(comparingInt(String::length))
                .toList();
    }

    public static boolean allStringsLongerThanOne(List<String> strings) {
        return strings.stream()
                .allMatch(s -> s.length() > 1);
    }

    public static Optional<String> findLongestStringGreaterThan(List<String> strings, int targetLength) {
        return strings.stream()
                .filter(s -> s.length() > targetLength)
                .min(comparingInt(String::length));
    }

    public static List<Integer> getStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("Java", "Python", "JavaScript", "C++", "Ruby");

        int sum = sumEvenNumbers(list);
        int max = findMax(list);
        OptionalDouble average = calculateAverage(list);
        long count = countStartsWithJ(strings);
        List<String> sortedStrings = sortByLength(strings);
        boolean allMatch = allStringsLongerThanOne(strings);
        Optional<String> longestString = findLongestStringGreaterThan(strings, 5);
        List<Integer> lengths = getStringLengths(strings);

        System.out.println("Sum of even numbers: " + sum);
        System.out.println("Max number: " + max);
        System.out.println("Average: " + average.orElse(0.0));
        System.out.println("Count of strings starting with J: " + count);
        System.out.println("Sorted strings: " + sortedStrings);
        System.out.println("All strings longer than 1 character: " + allMatch);
        System.out.println("Longest string longer than 5 characters: " + longestString.orElse("None"));
        System.out.println("Lengths of strings: " + lengths);
    }
}
