package school.faang.BJS2_57860;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input set cannot be null or empty");
        }

        return numbers.stream()
                .flatMap(num -> numbers.contains(sum - num) && num < sum - num
                        ? Stream.of((Arrays.asList(num, sum - num)))
                        : Stream.empty())
                .collect(Collectors.toSet());
    }

    public static List<String> sortCities(Map<String, String> country) {
        checkNull(country);

        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterByStartCharAndSortByLength(List<String> strings, char symbol) {
        checkNull(strings);

        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        checkNull(numbers);

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortStringsByAlphabet(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null || alphabet.isEmpty()) {
            throw new IllegalArgumentException("Input strings or alphabet cannot be null or empty");
        }

        var allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private static <T> void checkNull(T param) {
        if (param == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
    }
}
