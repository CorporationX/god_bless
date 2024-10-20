package school.faang.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class FilterStringsByAlphabet {
    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        List<String> validStrings = new ArrayList<>();
        String regex = "[" + alphabet + "]+";

        validStrings = strings.stream()
                .filter(s -> s.matches(regex))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        return validStrings;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = filterStringsByAlphabet(strings, alphabet);
        System.out.println("Filtered and sorted alphabet strings: " + result);
    }
}
