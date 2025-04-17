package school.faang.bjs2_70763;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class Operations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, Integer target) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .filter(num -> num != target - num && numbers.contains(target - num))
            .map(num -> Arrays.asList(num, target - num))
            .peek(Collections::sort)
            .collect(Collectors.toSet());
    }

    public static List<String> getCapitalBySortedCountry(Map<String, String> countries) {
        return countries.keySet().stream()
            .sorted(String::compareToIgnoreCase)
            .map(countries::get)
            .collect(Collectors.toList());
    }

    public static List<String> getSortingByLengthWords(List<String> words, char startChar) {
        return words.stream()
            .filter(Objects::nonNull)
            .filter(word -> !word.isEmpty() && word.charAt(0) == startChar)
            .sorted(String::compareTo)
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .map(Integer::toBinaryString)
            .toList();
    }

    public static List<String> getFilteringAndSorting(List<String> words, String alphabet) {
        String reg = "[" + alphabet + "]+";
        return words.stream()
            .filter(Objects::nonNull)
            .filter(word -> word.matches(reg))
            .sorted(String::compareTo)
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }
}
