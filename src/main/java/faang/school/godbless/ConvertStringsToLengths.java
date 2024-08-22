package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsToLengths {
    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}