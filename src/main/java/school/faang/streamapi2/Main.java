package school.faang.streamapi2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        List<String> strings = List.of("apple", "banana", "UPPERCASE", "cherry", "date", "numbers123", "fig", "grape", "!@#$");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String, String> countryAndCapital = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");

        System.out.println("Initial list of numbers:" + nums);
        System.out.println("Expected sum: 6");
        System.out.println("Solution Traditional Approach: " + findUniquePairsTraditionalWay(nums, 6));
        System.out.println("Task 1 - Solution with Streams: " + findUniquePairsStream(nums, 6));
        System.out.println("Task 2 - Capitals: " + getCapitalsSortedByCountries(countryAndCapital));
        System.out.println("Task 3 - Char Filter and Sort by length: " + filterAndSort(strings, 'a'));
        System.out.println("Task 4 - Binary Conversion: " + convertToBinary(nums));
        System.out.println("Task 5 - Alphabet Filter and Sort by length: " + filterAndSort(strings, alphabet));
    }

    public static Set<List<Integer>> findUniquePairsTraditionalWay(List<Integer> nums, int result) {
        Set<List<Integer>> pairs = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == result) {
                    pairs.add(List.of(nums.get(i), nums.get(j)));
                }
            }
        }
        return pairs;
    }

    public static Set<List<Integer>> findUniquePairsStream(List<Integer> nums, int result) {
        Set<Integer> uniqueNumbers = new HashSet<>(nums);
        List<Integer> halfOfResultValue = nums.stream().filter(n -> (n * 2 == result)).toList();
        if (halfOfResultValue.size() == 1) {
            uniqueNumbers.remove(halfOfResultValue.get(0));
        }

        return nums.stream()
                .filter(n -> uniqueNumbers.contains(result - n))
                .map(n -> Stream.of(n, result - n).sorted().toList())
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountries(Map<String, String> countryAndCapital) {
        return countryAndCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> filterAndSort(List<String> strings, char filter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(filter)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(ch -> alphabet.indexOf(ch) >= 0))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}
