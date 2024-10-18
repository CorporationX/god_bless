package school.faang.streamapitwo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetStringFilter {

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
