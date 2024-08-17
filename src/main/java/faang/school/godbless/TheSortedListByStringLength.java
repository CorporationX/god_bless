package faang.school.godbless;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TheSortedListByStringLength {
    public static List<String> sortedListByStringLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}