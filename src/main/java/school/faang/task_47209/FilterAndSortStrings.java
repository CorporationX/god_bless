package school.faang.task_47209;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndSortStrings {
    public static List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char letter = 'a';

        List<String> result = filterAndSort(strings, letter);
        System.out.println(result);
    }
}