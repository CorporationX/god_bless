package school.faang.bjs2_89200;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    private static final Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
    private static final int NUMBER = 4;
    private static final Map<String, String> COUNTERS =
            Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    private static final List<String> STRINGS = List.of("Bananza", "Bomba", "Berlingo", "Bona Sera");
    private static final List<String> WORDS = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final char SIMBOL = 'B';
    private static final List<Integer> DECIMAL = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        ManagerOperation managerOperation = new ManagerOperation();
        System.out.println(managerOperation.uniquePairsNum(numbers, NUMBER));
        System.out.println(managerOperation.sortingCapitals(COUNTERS));
        System.out.println(managerOperation.filtersStringByLength(STRINGS, SIMBOL));
        System.out.println(managerOperation.convertBinary(DECIMAL));
        System.out.println(managerOperation.filterStringByAlphabet(WORDS, ALPHABET));
    }
}
