package school.faang.train_stream_api_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> uniqueCouples(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> numbers.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filteringAndSortingLines(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s != null && s.toLowerCase().startsWith(prefix.toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> transformationOfNumbersIntoBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabetAndLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s != null && s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
