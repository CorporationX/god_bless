package school.faang.stream_api_2;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AlphabeticalStringFilterAndSorter {
    public static List<String> alphabeticalFilterAndSorter(List<String> strings, Set<Character> alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}