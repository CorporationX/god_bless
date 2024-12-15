package school.faang.task_47209;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringsByAlphabet {
    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> result = filterAndSortByLength(strings, alphabet);
        System.out.println(result);
    }
}