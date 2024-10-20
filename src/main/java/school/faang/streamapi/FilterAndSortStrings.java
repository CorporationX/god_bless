package school.faang.streamapi;

import java.util.*;

public class FilterAndSortStrings {
    private final static String SYMBOL = "a";

    public static List<String> filterAndSortStrings(List<String> strings, String character) {
        List<String> filtered = new ArrayList<>();
        filtered = strings.stream().filter(word -> word.startsWith(character))
                .sorted((word1, word2) -> word1.length() - word2.length()).toList();
        return filtered;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        List<String> result = filterAndSortStrings(strings, SYMBOL);
        System.out.println("Filtered and sorted strings: " + result);
    }
}
