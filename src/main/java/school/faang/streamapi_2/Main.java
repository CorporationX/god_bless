package school.faang.streamapi_2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        log.info(ListOperations.findUniquePairs(numbers, 6).toString());

        Map<String, String> countryCapital =
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        log.info(ListOperations.sortCountriesByAlphabetAndGetCapitals(countryCapital).toString());

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        log.info(ListOperations.filterAndSort(strings, 'a').toString());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        log.info(ListOperations.convertToBinary(nums).toString());

        strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        log.info(ListOperations.filterAndSortByAlphabet(strings, "abcdefghijklmnopqrstuvwxyz").toString());
    }
}
