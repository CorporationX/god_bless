package school.faangSprint2.t9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;
        System.out.println(Solution.findUniquePairs(input, target));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(Solution.sortAndGetCapitals(countries));

        List<String> fruitsInput = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        System.out.println(Solution.filterAndSortStrings(fruitsInput, startChar));

        List<Integer> inputMapBinary = Arrays.asList(1, 2, 3, 4);
        System.out.println(Solution.convertToBinary(inputMapBinary));

        List<String> inputForFilterAndSort = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Solution.filterAndSortByAlphabet(inputForFilterAndSort, alphabet));
    }
}

class Solution {
    public static List<String> sortAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> findUniquePairs(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(j) > numbers.indexOf(i))
                        .filter(j -> i + j == target)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == startChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}