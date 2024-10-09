package dima.evseenko.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterAndSorting(List<String> strings, char chr) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(chr))).sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> numbersToBinaries(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        return strings.stream().filter(s -> {
            for (Character c : s.toCharArray()) {
                if (!alphabet.contains(String.valueOf(c))) {
                    return false;
                }
            }
            return true;
        }).sorted(Comparator.comparing(String::length)).toList();
    }
}
