package StreamApi.two;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSortWithFiltering {
    public static List<String> stringSortWithFiltering(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars().allMatch(character -> alphabet.indexOf(character) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
