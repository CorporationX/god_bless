package school.faang.BJS235248;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public Set<List<Integer>> uniqueNumbers(List<Integer> numbers, int value) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(value - num))
                .map(num -> Arrays.asList(num, value - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public List<String> sortCountries(Map<String, String> countryToCapital) {
        return countryToCapital.keySet().stream()
                .sorted()
                .map(countryToCapital::get)
                .collect(Collectors.toList());
    }

    public List<String> sortByChar(List<String> lines, char ch) {
        return lines.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .collect(Collectors.toList());
    }

    public List<String> numbersToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public List<String> filteredByAlphabetAndLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        System.out.println(solution.uniqueNumbers(listOfNumbers, 10));

        System.out.println();
        Map<String, String> mapOfCountries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        System.out.println(solution.sortCountries(mapOfCountries));
        System.out.println();

        List<String> listOfStrings = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(solution.sortByChar(listOfStrings, 'a'));
        System.out.println();

        System.out.println(solution.numbersToBinary(listOfNumbers));
        System.out.println();

        List<String> list = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(solution.filteredByAlphabetAndLength(list, "abcdefghijklmnopqrstuvwxyz"));
    }
}
