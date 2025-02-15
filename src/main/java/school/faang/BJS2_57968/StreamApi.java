package school.faang.BJS2_57968;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {

    public static Set<List<Integer>> uniquePairsOfNumbers(Set<Integer> numbers, int value) {
        return numbers.stream()
                .flatMap(num -> numbers.stream()
                        .filter(val -> num + val == value && num < val)
                        .map(val -> List.of(num, val)))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountryAndPrintCapital(Map<String, String> countries) {
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filterAndSortedString(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> !str.isBlank() && str.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringByAlphabetAndSortedByLength(List<String> strings, String alphabet) {
        String pattern = "^[%s]+$".formatted(alphabet);
        return strings.stream()
                .filter(str -> str.matches(pattern))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
