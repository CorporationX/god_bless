package school.faang.bjs2_80666;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.bjs2_80666.Service.*;

@Slf4j
public class Main {
    private static final char FIRST_SYMBOL = 'a';
    private static final int SUM = 6;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private static Map<String, String> countryCapital =
            Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    private static List<String> strings =
            Arrays.asList("apple", "banana", "avocado", "apricot", "cherry", "date", "fig", "grape");
    private static Set<Integer> numberSet = Set.of(1, 2, 3, 4, 5, 6);
    private static List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {
        Set<Set<Integer>> uniquePair = findUniquePairBySum(numberSet, SUM);
        log.info(uniquePair.toString());

        List<String> sortedCapital = getSortedCapital(countryCapital);
        log.info(sortedCapital.toString());

        List<String> filteredString = filterAndSortStartingWith(strings, FIRST_SYMBOL);
        log.info(filteredString.toString());

        List<String> binaryNums = toBinary(numberList);
        log.info(binaryNums.toString());

        List<String> sortedStrings = filterAndSort(strings, ALPHABET);
        log.info(sortedStrings.toString());
    }
}
