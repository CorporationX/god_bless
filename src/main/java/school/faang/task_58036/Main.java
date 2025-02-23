package school.faang.task_58036;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Set<Integer> NUMB_SET = Set.of(1, 2, 3, 4, 5, 6);
    private static final Map<String, String> COUNTRIES_MAP = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin"
    );
    private static final List<Integer> NUMB_LIST = List.of(1, 2, 3, 4);
    private static final List<String> LIST = List.of("apple", "banana", "avocado", "apricot");
    private static final List<String> LIST_STRING = List.of("apple", "banana", "cherry", "date", "fig", "grape");

    private static final int TARGET_SUM_NUM = 6;
    private static final char FILTER_LETTER = 'a';
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        System.out.printf("Вход: %s, целевое число: %s\nВыход: %s \n\n",
                NUMB_SET, TARGET_SUM_NUM, ListOperations.findPairs(NUMB_SET, TARGET_SUM_NUM));

        System.out.printf("Вход: %s\nВыход: %s \n\n",
                COUNTRIES_MAP, ListOperations.getSortedCapitals(COUNTRIES_MAP));

        System.out.printf("Вход: %s\nВыход: %s \n\n",
                LIST, ListOperations.filterAndSort(LIST, FILTER_LETTER));

        System.out.printf("Вход: %s\nВыход: %s \n\n",
                NUMB_LIST, ListOperations.convertToBinary(NUMB_LIST));

        System.out.printf("Вход: %s\nВыход: %s \n\n",
                LIST_STRING, ListOperations.filterAndSortByLength(LIST_STRING, ALPHABET));
    }
}
