package school.faang.streamapi2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    private static final Set<Integer> NUMBERS_SET = Set.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> NUMBERS_LIST = List.of(1, 2, 3, 4);
    private static final List<String> WORDS_LIST = List.of("apple", "banana", "avocado", "apricot");
    private static final List<String> FRUITS_LIST = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    private static final Map<String, String> COUNTRIES = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin"
    );
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final char FILTER_CHAR = 'a';
    private static final int TARGET_SUM_NUM = 6;

    public static void main(String[] args) {
        // first task test
        List<int[]> result = Solution.findUniquePairs(NUMBERS_SET, TARGET_SUM_NUM);
        String output = result.stream()
                .map(pair -> "(" + pair[0] + ", " + pair[1] + ")")
                .collect(Collectors.joining(", "));
        System.out.printf("Найденные пары: %s%n",
                output);

        // second task test
        List<String> capitals = Solution.getSortedCapitals(COUNTRIES);
        System.out.printf("Столицы, отсортированные по странам: %s%n",
                capitals);

        // third task test
        List<String> filteredSorted = Solution.filterAndSortByChar(WORDS_LIST, FILTER_CHAR);
        System.out.printf("Строки, начинающиеся на '%s', отсортированные по длине: %s%n",
                FILTER_CHAR, filteredSorted);

        // fourth task test
        List<String> binaryNumbers = Solution.convertNumbersToBinary(NUMBERS_LIST);
        System.out.printf("Числа в двоичном формате: %s%n",
                binaryNumbers);

        // fifth task test
        List<String> filteredFruits = Solution.filterByAlphabetAndSort(FRUITS_LIST, ALPHABET);
        System.out.printf("Строки, содержащие символы только из алфавита, отсортированные по длине: %s%n",
                filteredFruits);
    }
}
