package school.faang.bjs2_70763;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> uniqueNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<List<Integer>> uniquePair = Operations.findUniquePairs(uniqueNumbers, 6);
        log.info("unique pairs: {}", uniquePair);

        // Вход: {"Russia": "Moscow", "USA": "Washington", "Germany": "Berlin"}
        // Выход: ["Berlin", "Moscow", "Washington"]
        Map<String, String> countries = new HashMap<>(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"));
        List<String> capitals = Operations.getCapitalBySortedCountry(countries);
        log.info("sorted capitals list: {}", capitals);

        // Вход: ["apple", "banana", "avocado", "apricot"], символ: 'a'
        // Выход: ["apple", "apricot", "avocado"]
        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> sortedWords = Operations.sortByLength(words, 'a');
        log.info("sorted word by length: {}", sortedWords);
    }
}
