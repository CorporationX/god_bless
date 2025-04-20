package trainstreamapi2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        Set<Integer> seen = new HashSet<>();
        return numbers.stream()
                .filter(num -> {
                    int other = sum - num;
                    return numbers.contains(other) && !seen.contains(other);
                })
                .peek(num -> seen.add(num))
                .map(num -> {
                    int other = sum - num;
                    return List.of(Math.min(num, other), Math.max(num, other));
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndPrintCapitals(Map<String, String> countriesToCapitals) {
        return countriesToCapitals.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char c) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(c))).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream().filter(s -> s.matches(regex)).sorted(Comparator.comparingInt(String::length)).toList();
    }
}
