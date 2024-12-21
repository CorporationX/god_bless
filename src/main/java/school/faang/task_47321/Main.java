package school.faang.task_47321;

import java.util.List;
import java.util.Map;

public class Main {
    public static final List<Integer> SIX_INTEGERS = List.of(1, 2, 3, 4, 5, 6);
    public static final Integer TARGET_NUMBER = 7;
    public static final Map<String, String> COUNTRIES_WITH_CAPITALS = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin"
    );

    public static final List<String> FOUR_STRINGS = List.of("apple", "banana", "avocado", "apricot");
    public static final String STARTING_SYMBOL = "a";
    public static final List<Integer> FOUR_INTEGERS = List.of(1, 2, 3, 4);

    public static final List<String> SIX_STRINGS = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        ListOperations listOperations = new ListOperations(SIX_INTEGERS); // Передаём список через конструктор

        System.out.println("Уникальные пары: " + listOperations.findUniquePairs(TARGET_NUMBER));
        System.out.println("Столицы: " + listOperations.findSortedCapitals(COUNTRIES_WITH_CAPITALS));
        System.out.println("Строки с заданного символа: " + listOperations.findSortedStringsStartsWith(FOUR_STRINGS,
                STARTING_SYMBOL));
        System.out.printf("Числа: %s В двоичный формат: %s %n", FOUR_INTEGERS,
                listOperations.findBinaryListFromIntegers(FOUR_INTEGERS));
        System.out.println("Фильтр по алфавиту: " + listOperations.filterAllMatchingAsc(SIX_STRINGS, ALPHABET));
    }
}
