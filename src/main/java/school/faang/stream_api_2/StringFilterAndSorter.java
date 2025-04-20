package school.faang.stream_api_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringFilterAndSorter {
    public static List<String> filterAndSortStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}