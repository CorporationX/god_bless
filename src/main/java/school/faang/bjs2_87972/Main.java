package school.faang.bjs2_87972;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Integer> NUMBERS = Set.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> NUMBERS_LIST = List.of(1, 2, 3, 4, 5, 6);
    private static final int TARGET_NUMBER = 6;
    private static final Map<String, String> COUNTIES =
            Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    private static final List<String> STRINGS = List.of("apple", "banana", "avocado", "apricot");
    private static final char FILTER_CHAR = 'a';
    private static final List<String> FILTERED_STRINGS = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.printf("Уникальные пары чисел, сумма которых равна %d %s\n",
                TARGET_NUMBER, ManagerOperations.findPairDistinctNumbers(NUMBERS, TARGET_NUMBER));

        System.out.printf("Отсортированный список столиц: %s\n", ManagerOperations.sortedCapitals(COUNTIES));

        System.out.printf("Отфильтрованный по символу %s и отсортированный список строк: %s\n",
                FILTER_CHAR, ManagerOperations.filteredStings(STRINGS, FILTER_CHAR));

        System.out.printf("Числа в довичном формате: %s\n", ManagerOperations.convertingNumbers(NUMBERS_LIST));

        System.out.printf("Фильтрация по алфавиту и сортировка по длине: %s\n",
                ManagerOperations.filterAndSortByLength(FILTERED_STRINGS, ALPHABET));
    }
}
