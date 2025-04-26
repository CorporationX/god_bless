package school.faang.bjs_70946;

import java.util.*;
import java.util.stream.Collectors;

public class FilterAndSortStrings {
    public static List<String> filterAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char ch = 'a';

        List<String> result = filterAndSortStrings(strings, ch);
        System.out.println(result);
    }
}
