package school.faang.filter_and_sorted_strings;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';

        List<String> result = filterAndSortedStrings(fruits, symbol);
        System.out.println(result);
    }

    private static List<String> filterAndSortedStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
