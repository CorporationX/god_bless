package school.faang.stream2;

import java.util.*;
import java.util.stream.Collectors;

public class Operation {
    public static Set<List<Integer>> uniquePairNumbers(Set<Integer> numbers, int number) {
        return numbers.stream()
                .distinct()
                .filter(num -> num != number - num && numbers.contains(number - num))
                .map(num -> Arrays.asList(num, number - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountiesAndOutputCapitals(Map<String, String> countiesAndCapitals) {
        return countiesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortString(List<String> lines, char character) {
        return lines.stream()
                .filter(str -> str.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> alphabetically(List<String> lines, String alphabet) {
        return lines.stream()
                .filter(str -> Arrays.stream(str.split(""))
                        .allMatch(ch -> Arrays.asList(alphabet.split("")).contains(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
