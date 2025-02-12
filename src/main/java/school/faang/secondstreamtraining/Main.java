package school.faang.secondstreamtraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int sum = 6;
        logger.info(streamOperations.findUniquePairs(numbers, sum).toString());

        Map<String, String> countriesCapitals =
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        logger.info(streamOperations.sortCountriesAndPrintCapitals(countriesCapitals).toString());

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char firstChar = 'a';
        logger.info(streamOperations.filterAndSortStrings(fruits, firstChar).toString());

        List<Integer> decimals = List.of(1, 2, 3, 4);
        logger.info(streamOperations.transformDecimalToBinary(decimals).toString());

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        logger.info(streamOperations.filterByAlphabetSortByLength(words, alphabet).toString());
    }
}
