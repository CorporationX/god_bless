package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        final int sum = 6;
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> words = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(findPairs(numbers, sum));
        System.out.println(getSortedCapitals(countries));
        System.out.println(sortStrings(fruits, symbol));
        System.out.println(convertToBinary(nums));
        System.out.println(filterAndSortByLength(words, alphabet));
    }

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .flatMap(n -> numbers.stream()
                        .filter(x -> n < x && n + x == sum)
                        .map(x -> Arrays.asList(n, x)))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortStrings(List<String> fruits, char symbol) {
        return fruits.stream()
                .filter(f -> !f.isEmpty() && f.charAt(0) == symbol)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(w -> w.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

}
