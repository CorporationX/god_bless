package school.faang.sprint_2.task_47271;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .sorted()
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter((str) -> {
                    for (char letter : str.toCharArray()) {
                        if (!alphabet.contains(String.valueOf(letter))) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
