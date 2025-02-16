package school.faang.practice_streamapi_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Set<Integer> numbersSet = Set.of(1, 2, 3, 4, 5, 6);
        logger.info("There is set of numbers: {}", numbersSet);
        logger.info("Set of pairs: {}", StreamApiPractice.findPairs(numbersSet, 6));
        logger.info(StreamApiPractice.capitalSortedCountry(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin")).toString());
        logger.info(StreamApiPractice.stringFilterAndSorted(
                List.of("apple", "banana", "avocado", "apricot"),
                'a').toString());
        logger.info(StreamApiPractice.converterIntDecToBiString(List.of(1, 2, 3, 4)).toString());
        logger.info(StreamApiPractice.stringFilterAlphabetAndSorted(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString());
    }
}
