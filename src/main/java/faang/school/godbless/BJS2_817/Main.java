package faang.school.godbless.BJS2_817;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<String> strings = List.of("apple", "banana", "orange", "kiwi", "grape");
        String substring = "an";

        System.out.println("Sum of even numbers: " + sumOfEven(numbers));
        if (maxValue(numbers).isPresent()) {
            System.out.println("Max value: " + maxValue(numbers));
        }
        System.out.println("Average value: " + averageValue(numbers));
        System.out.println("Count of strings starting with 'a': " + countOfStringsWithStartChar(strings, 'a'));
        System.out.println("Filter by substring '" + substring + "': " + filterBySubstring(strings, substring));
        System.out.println("Filter by exact length 5: " + filterByLength(strings, 5));
        System.out.println("Any string longer than 3 characters: " + filterByPredicate(strings, s -> s.length() > 3));
        System.out.println("Minimum string length more than 3: " + findMinMoreThan(strings, 3).orElse("No such string"));
        System.out.println("Mapped lengths: " + mapToLength(strings));
    }

    public static int sumOfEven(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> maxValue(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder());
    }

    public static double averageValue(List<Integer> numbers) {
        double average = numbers.stream().mapToDouble(Integer::valueOf).sum();
        if (average == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return average / numbers.size();
    }

    public static int countOfStringsWithStartChar(List<String> strings, char startChat) {
        return (int) strings.stream().filter(str -> !str.isEmpty() && str.charAt(0) == startChat).count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> filterByLength(List<String> strings, int length) {
        return strings.stream().filter(s -> s.length() == length).toList();
    }

    public static boolean filterByPredicate(List<String> strings, Predicate<String> check) {
        return strings.stream().anyMatch(check);
    }

    public static Optional<String> findMinMoreThan(List<String> strings, int minLength) {
        return strings.stream().filter(s -> s.length() > minLength).min(Comparator.comparing(String::length));
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}