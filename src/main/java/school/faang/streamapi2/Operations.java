package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> num < target && num != target - num && numbers.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filteredAndSorted(List<String> words, char target) {
        return words.stream()
                .filter(s -> s.charAt(0) == target)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortedAndFiltered(List<String> words, String alfabet) {
        String regex = "^[" + alfabet + "]+$";
        return words.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
