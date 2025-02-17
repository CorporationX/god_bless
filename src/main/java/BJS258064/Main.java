package BJS258064;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final Set<Integer> numbersSet = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<Integer> numbersList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Map<String, String> countryAndCapitals = Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin", "Brazil", "Brasilia");
        final List<String> stringList = List.of("apple", "orange", "banana", "pineapple", "melon",
                "bob", "mint", "mushrooms");
        final String alphabet = "[leapob]+";

        ServiceOperations operations = new ServiceOperations();

        log.info("Get pair numbers : ");
        System.out.println(operations.getPairNumbers(numbersSet, 8));
        log.info("Get capital of country : ");
        System.out.println(operations.getCapitalOfCountry(countryAndCapitals));
        log.info("Get string by symbol : ");
        System.out.println(operations.filteredAndSortedStrings(stringList, 'm'));
        log.info("get from int to binary string : ");
        System.out.println(operations.fromIntToBinary(numbersList));
        log.info("get by alphabet and sorted by length : ");
        System.out.println(operations.filterByAlphabetSortByLength(stringList, alphabet));

    }
}
