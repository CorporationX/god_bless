package bjs257886;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("{}", TaskStreamApi.findUniquePairsNumbers(getSetUniqueNumbers(), 6));
        logger.info("{}", TaskStreamApi.sortCountriesAndGetCapitals(getCountryToCapital()));
        logger.info("{}", TaskStreamApi.findAndSortStrings(getStringsToSortByLength(), 'a'));
        logger.info("{}", TaskStreamApi.convertNumbersToBinaryFormat(getStringsToConvertInBinaryFormat()));
        logger.info("{}", TaskStreamApi.filterStringsAndSortByLength(getStringsToSortByLengthAndOrder()));
    }

    private static Set<Integer> getSetUniqueNumbers() {
        return Set.of(1, 2, 3, 4, 5, 6);
    }

    private static Map<String, String> getCountryToCapital() {
        return Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    }

    private static List<String> getStringsToSortByLength() {
        return List.of("apple", "banana", "avocado", "apricot", "aaaaaaaaaa");
    }

    private static List<Integer> getStringsToConvertInBinaryFormat() {
        return List.of(1, 2, 3, 4);
    }

    private static List<String> getStringsToSortByLengthAndOrder() {
        return List.of("apple", "banana", "cherry", "date", "fig", "grape", "буквы не из заданного алфавита", "",
                "som;ethingW:ith(NoLe:tterSymbo=ls");
    }
}
