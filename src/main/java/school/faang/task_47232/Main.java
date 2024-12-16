package school.faang.task_47232;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Integer> NUM = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final Map<String, String> COUNTRIES = new HashMap<>();
    private static final List<String> FRUITS = Arrays.asList("apple", "banana", "avocado", "apricot", "12a");
    private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        COUNTRIES.put("Россия", "Москва");
        COUNTRIES.put("Украина", "Киев");
        COUNTRIES.put("Белорусия", "Минск");
        COUNTRIES.put("Польша", "Варшава");

        ListOperations.findPairs(NUM, 6).stream()
                .forEach(System.out::println);
        ListOperations.sortingCountries(COUNTRIES).stream()
                .forEach(System.out::println);
        ListOperations.sortStrings(FRUITS, 'a').stream()
                .forEach(System.out::println);
        ListOperations.convertToBinaryNumbers(NUM).stream()
                .forEach(System.out::println);
        ListOperations.filterAndSortByLength(FRUITS, ENGLISH_ALPHABET).stream()
                .forEach(System.out::println);
    }
}
