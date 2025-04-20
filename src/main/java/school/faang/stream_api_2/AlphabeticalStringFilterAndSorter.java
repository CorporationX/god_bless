package school.faang.stream_api_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabeticalStringFilterAndSorter {
    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.contains(String.valueOf((char) c))))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}