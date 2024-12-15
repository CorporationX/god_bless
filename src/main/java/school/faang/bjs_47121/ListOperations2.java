package school.faang.bjs_47121;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations2 {
    public static Set<List<Integer>> getPairOfNumbers(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(n -> numbers.contains(sum - n))
                .collect(Collectors.toMap(k -> k, v -> sum - v))
                .entrySet()
                .stream()
                .map(entry -> Stream.of(entry.getKey(), entry.getValue())
                        .sorted()
                        .toList())
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getFilteredAndSortedStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> getNumbersInBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> getFilteredByAlphabetAndSortedStrings(List<String> strings, String filterString) {
        String regEx = "[" + filterString + "]*";
        Pattern pattern = Pattern.compile(regEx);
        return strings.stream()
                .filter(string -> string.matches(pattern.pattern()))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

}
