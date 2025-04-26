package school.faang.bjs_70946;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterByAlphabet {
    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        String regex = "^["
                + Pattern.quote(alphabet)
                + "]+$";
        Pattern pattern = Pattern.compile(regex);

        return strings.stream()
                .filter(s -> pattern.matcher(s).matches())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> result = filterAndSortByAlphabet(strings, alphabet);
        System.out.println(result);
    }
}
