package streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        System.out.println("===Check method nums===");
        System.out.println(sum(nums));

        nums = Arrays.asList(1, 2, 3, 5, 222, 7, 8, 9, 10);
        System.out.println("\n===Check method max===");
        System.out.println(max(nums));

        nums = Arrays.asList(1, 2, 3, 4, 5, 20);
        System.out.println("\n===Check method avgValue===");
        System.out.println(avgValue(nums));

        List<String> strings = List.of("Hello", "Hi-Tech", "Mom", "Dad", "House");
        System.out.println("\n===Check method countStringsWhichStartsWithASymbol===");
        System.out.println(countStringsWhichStartsWithASymbol(strings, str -> str.charAt(0) == 'H'));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming is cool");
        System.out.println("\n===Check method filterStringsBySubstring===");
        System.out.println(filterStringsBySubstring(strings, str -> str.contains("Mom")));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming is cool");
        System.out.println("\n===Check method sortByLength===");
        System.out.println(sortByLength(strings));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming");
        System.out.println("\n===Check method checkConditionForString===");
        System.out.println(checkConditionForString(strings, str -> str.length() > 12));

        nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        System.out.println("\n===Check method findMinElementInListWhichOverGivenNumber===");
        System.out.println(findMinElementInListWhichOverGivenNumber(nums, 5));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming");
        System.out.println("\n===Check method mapListOfStringsInListOfLengths===");
        System.out.println(mapListOfStringsInListOfLengths(strings));

    }

    static int sum(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    static int max(List<Integer> nums) {
        return nums.stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }

    static double avgValue(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum) / (double) nums.size();
    }

    static long countStringsWhichStartsWithASymbol(List<String> strings, Predicate<String> conditionForCounter) {
        return strings.stream()
                .filter(conditionForCounter)
                .count();
    }

    static List<String> filterStringsBySubstring(List<String> strings, Predicate<String> conditionForFilter) {
        return strings.stream()
                .filter(conditionForFilter)
                .toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    static Map<Boolean, List<String>> checkConditionForString(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .collect(Collectors.partitioningBy(condition));
    }

    static int findMinElementInListWhichOverGivenNumber(List<Integer> nums, int number) {
        return nums.stream()
                .filter(num -> num > number)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
    }

    static List<Integer> mapListOfStringsInListOfLengths(List<String> strings) {
        return strings.stream()
                .map(s -> s.length())
                .toList();
    }
}

