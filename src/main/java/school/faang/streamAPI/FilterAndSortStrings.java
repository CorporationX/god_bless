package school.faang.streamAPI;

import java.util.*;

public class FilterAndSortStrings {
    public static List<String> filterAndSortStrings(List<String> strings, char character) {
        List<String> filtered = new ArrayList<>();

        for (String str : strings) {
            if (str.charAt(0) == character) {
                filtered.add(str);
            }
        }

        filtered.sort(Comparator.comparingInt(String::length));
        return filtered;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char character = 'a';
        List<String> result = filterAndSortStrings(strings, character);
        System.out.println("Filtered and sorted strings: " + result);
    }
}
