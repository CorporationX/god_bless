package school.faang.task_47232;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final Map<String, String> countries = new HashMap<>();
    private static final List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot", "12a");
    private static final String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        countries.put("Россия", "Москва");
        countries.put("Украина", "Киев");
        countries.put("Белорусия", "Минск");
        countries.put("Польша", "Варшава");

        ListOperations.findPairs(num, 6).stream()
                .forEach(System.out::println);
        ListOperations.sortingCountries(countries).stream()
                .forEach(System.out::println);
        ListOperations.sortStrings(fruits, 'a').stream()
                .forEach(System.out::println);
        ListOperations.convertToBinaryNumbers(num).stream()
                .forEach(System.out::println);
        ListOperations.filterAndSortByLength(fruits, englishAlphabet).stream()
                .forEach(System.out::println);
    }
}
