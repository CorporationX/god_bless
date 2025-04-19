package school.faang.streamApi.training_two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByChar(List<String> words, char symbol) {
        return words.stream()
                .filter(word -> word.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> fromDecimalToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterWithAlphabetAndSortByLength(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(word -> alphabet.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
