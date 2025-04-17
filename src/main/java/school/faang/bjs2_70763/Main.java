package school.faang.bjs2_70763;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> uniqueNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<List<Integer>> uniquePair = Operations.findUniquePairs(uniqueNumbers, 6);
        log.info("unique pairs: {}", uniquePair);

        Map<String, String> countries =
            new HashMap<>(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"));
        List<String> capitals = Operations.getCapitalBySortedCountry(countries);
        log.info("sorted capitals list: {}", capitals);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot", "grape");
        List<String> sortedWords = Operations.getSortingByLengthWords(words, 'a');
        log.info("sorted word by length: {}", sortedWords);

        List<String> binaryList = Operations.convertToBinary(uniqueNumbers);
        log.info("binary list: {}", binaryList);

        List<String> anotherWords =
            Arrays.asList("grape", "apple", "banana", "cherry", "date", "fig", "яблоко", "GRAPE");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filterindAndSortingList = Operations.getFilteringAndSorting(anotherWords, alphabet);
        log.info("filtering and sorting list: {}", filterindAndSortingList);
    }
}
