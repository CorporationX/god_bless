package school.faang.bjs247191;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class StreamApi1 {

    public static int sumEvenNumbers(List<Integer> numbers) {
        Integer i = numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
        log.info("Sum of even numbers: {}", i);
        return i;
    }

    public static int maxListElement(List<Integer> numbers) {
        int max = numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("List is empty, cannot determine the maximum element"));
        log.info("Max element: {}", max);
        return max;
    }

    public static Double averageListElement(List<Integer> numbers) {
        Double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty, cannot determine the average element"));
        log.info("Average of elements: {}", average);
        return average;
    }

    public static int countStringCountWith(List<String> strings, char ch) {
        int count = (int) strings.stream().filter(str -> str.startsWith(String.valueOf(ch))).count();
        log.info("Count of strings starting with {}: {}", ch, count);
        return count;
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        List<String> str = strings.stream().filter(s -> s.contains(substring)).toList();
        log.info("Filtered strings containing '{}': {}", substring, str);
        return str;
    }

    public static List<String> sortList(List<String> strings) {
        List<String> str = strings.stream().sorted((s1, s2)
                -> Integer.compare(s1.length(), s2.length())).toList();
        log.info("Sorted list by length: {}", str);
        return str;
    }

    public static boolean isSatisfyCertainConditions(List<Integer> numbers, Predicate<Integer> check) {
        boolean b = numbers.stream().allMatch(check);
        log.info("All elements satisfy the condition: {}", b);
        return b;
    }

    public static int findMinGreaterThan(List<Integer> numbers, int minNumber) {
        Integer i = numbers.stream()
                .filter(num -> num > minNumber)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("No element greater than " + minNumber));
        log.info("Minimum number greater than {}: {}", minNumber, i);
        return i;
    }

    public static List<Integer> lenghtEachStrings(List<String> strings) {
        List<Integer> i = strings.stream().map(String::length).toList();
        log.info("Lengths of each string: {}", i);
        return i;
    }
}