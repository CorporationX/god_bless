package faang.school.godbless.StreamApi;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {

    public static int add(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list){
        return list.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("No max element found"));
    }

    public static double findAverage(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringStartWith(List<String> list, char startChar){
        return list.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == startChar)
                .count();
    }

    public static List<String> filterStringContainsSubstring(List<String> list, String substring){
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> filterStringByLength(List<String> list){
        return list.stream()
                .sorted(Comparator.comparingInt(String:: length))
                .collect(Collectors.toList());
    }

    public static boolean anyMatchTest(List<String> str, Predicate<String> predicate){
        return str.stream()
                .anyMatch(predicate);
    }

    public static Optional<Integer> findSmallestGreaterThan(List<Integer> numbers, int threshold){
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Integer::compareTo);
    }

    public static List<Integer> convertToLength(List<String> strings){
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
