package school.faang.bjs2_87935;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionTasks {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(n -> n != target - n && numbers.contains(target - n))
                .map(n -> Arrays.asList(n, target - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStringsByChar(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static void main(String[] args) {

        Set<Integer> nums = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println(findUniquePairs(nums, target));

        Map<String, String> countries =
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.println(sortCountriesAndGetCapitals(countries));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(filterAndSortStringsByChar(fruits, 'a'));

        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println(convertNumbersToBinary(numbers));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterByAlphabetAndSort(words, alphabet));
    }
}
