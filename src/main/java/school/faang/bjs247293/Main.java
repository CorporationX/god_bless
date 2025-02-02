package school.faang.bjs247293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numsList = List.of(1, 2, 3, 4, 5, 6);
        final Map<String, String> countryCity
                = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        final List<String> products = List.of("apple", "banana", "avocados", "apricot", "pineapple", "orange");

        Set<List<Integer>> pairsNum = StreamOperations.uniquePairNumbers(numsList, 7);
        System.out.println(pairsNum);

        List<String> onlyCity = StreamOperations.sortingCountry(countryCity);
        System.out.println(onlyCity);

        List<String> productsStartByA = StreamOperations.filterBySymbolAndSorting(products, 'a');
        System.out.println(productsStartByA);

        List<String> divideNumbers = StreamOperations.mappingNumInWordDivided(numsList);
        System.out.println(divideNumbers);

        List<String> wordContainsRegex = StreamOperations.filterWordByAlphabet(products, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(wordContainsRegex);
    }
}
