package school.faang.bjs2_89200;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerOperation {

    public Set<List<Integer>> uniquePairsNum(Set<Integer> decimal, int num) {
        return decimal.stream()
                .filter(number -> number != num - number && decimal.contains(num - number))
                .map(number -> Arrays.asList(number, num - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> sortingCapitals(Map<String, String> countries) {
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public List<String> filtersStringByLength(List<String> strings, char word) {
        return strings.stream()
                .filter(x -> x.startsWith(String.valueOf(word)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertBinary(List<Integer> decimal) {
        return decimal.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterStringByAlphabet(List<String> strings, String filter) {
        String regex = "[" + filter + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
