package school.faang.bjs270906;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> number != sum - number && numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> sortCapitals(Map<String, String> cities) {
        return cities.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> string.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
