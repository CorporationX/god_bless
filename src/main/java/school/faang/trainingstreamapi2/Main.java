package school.faang.trainingstreamapi2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    private static final Set<Integer> UNIQUE_NUMBERS = Set.of(2, 1, 4, 3, 6, 5);
    private static final Map<String, String> COUNTRY_MAP =
            Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    private static final List<String> LIST_WORDS =
            List.of("apple", "banana", "cherry", "cup", "date", "fig", "grape");
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final char SYMBOL = 'c';
    private static final int NUMBER = 6;
    private static final List<Integer> LIST_NUMBERS = List.of(6, 1, 5, 2, 4, 3);

    public static void main(String[] args) {
        try {
            log.info("Unique pairs which their sum equals - {}: {}", NUMBER,
                    Functions.findUniquePairNumbers(UNIQUE_NUMBERS, NUMBER));
            log.info("Sorted capitals of countries: {}", Functions.sortCountriesByCapitals(COUNTRY_MAP));
            log.info("Words which start with symbol - {}: {}", SYMBOL,
                    Functions.filterLinesWithSymbol(LIST_WORDS, SYMBOL));
            log.info("List numbers in binary representation: {}",
                    Functions.transformIntegerToBinaryLine(LIST_NUMBERS));
            log.info("Words which contains english alphabet: {}",
                    Functions.filterLinesWithAlphabet(LIST_WORDS, ALPHABET));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
