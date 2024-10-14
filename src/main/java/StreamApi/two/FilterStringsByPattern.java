package StreamApi.two;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringsByPattern {
    public static List<String> filterStringsByPattern(List<String> strings, char character) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith(String.valueOf(String.valueOf(character).toLowerCase())))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
