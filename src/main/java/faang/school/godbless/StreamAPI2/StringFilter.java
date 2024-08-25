package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.stream.Collectors;

public class StringFilter {
    public static List<String> filterAndSortStrings(List<String> strings, Set<Character> alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
