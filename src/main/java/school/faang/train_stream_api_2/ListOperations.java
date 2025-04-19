package school.faang.train_stream_api_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {
    public static Set<Set<Integer>> uniqueCouples(Set<Integer> numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        return numbers.stream()
                .flatMap(num -> {
                    int complement = target - num;
                    if (seen.contains(complement)) {
                        return Stream.of(new HashSet<>(Arrays.asList(Math.min(num, complement),
                                Math.max(num, complement))));
                    } else {
                        seen.add(num);
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filteringAndSortingLines(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s != null && s.toLowerCase().startsWith(prefix.toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
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
