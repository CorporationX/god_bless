package school.faang.module2.stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Filters {

    public static List<String> filterCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.values().stream()
                .sorted(String::compareTo)
                .toList();

    }

    public static List<String> filterStrings(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
                .toList();
    }

    public static List<String> mapIntsToBinary(List<Integer> ints) {
        return ints.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAllowedChars(List<String> strings, String allowedChars) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Set<Set<Integer>> findPairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == target)
                        .map(b -> Set.of(a, b)))
                .collect(Collectors.toSet());
    }

}
