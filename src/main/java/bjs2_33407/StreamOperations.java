package bjs2_33407;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairsEqualTarget(List<Integer> numbers,
                                                                int target) {
        Set<List<Integer>> uniquePairs;
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        uniquePairs = numbers.stream()
                .filter(num -> uniqueNumbers.contains(target - num) &&
                        (num != target - num || Collections.frequency(numbers, num) > 1))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        return uniquePairs;
    }

    public static List<String> getSortedCountryCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getKey().length() - entry1.getKey().length())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> words, char charToStartWith) {
        return words.stream()
                .filter(word -> word.startsWith(Character.toString(charToStartWith)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> containsCharFromAlphabet(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> {
                    for (char ch : alphabet.toCharArray()) {
                        if (word.contains(Character.toString(ch))) {
                            return true;
                        }
                    }
                    return false;
                })
                .sorted((word1, word2) -> word1.length() - word2.length())
                .toList();
    }
}
