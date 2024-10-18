package school.faang.streamapitwo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringFilterSorter {

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == startChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
