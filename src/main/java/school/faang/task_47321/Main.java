package school.faang.task_47321;

import java.util.List;
import java.util.Map;

import static school.faang.task_47321.ListOperations.*;

public class Main {
    public static final List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
    public static final Integer TARGET_NUMBER = 7;
    public static final Map<String, String> countriesWithCapitals = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin"
    );

    public static final List<String> FOUR_STRINGS = List.of("apple", "banana", "avocado", "apricot");
    public static final String STARTING_SYMBOL = "a";
    public static final List<Integer> INTEGERS = List.of(1, 2, 3, 4);


    public static final List<String> SIX_STRINGS = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println("Уникальные пары: " + findUniquePairs(integers, TARGET_NUMBER));
        System.out.println("Столицы: " + findSortedCapitals(countriesWithCapitals));
        System.out.println("Строки с заданного символа: " + findSortedStringsStartsWith(FOUR_STRINGS, STARTING_SYMBOL));
        System.out.printf("Числа: %s В двоичный формат: %s %n", INTEGERS, findBinaryListFromIntegers(INTEGERS));
        System.out.println("Фильтр по алфавиту и сортировка по длине: " + filterAllMatchingAsc(SIX_STRINGS, alphabet));
    }
}
