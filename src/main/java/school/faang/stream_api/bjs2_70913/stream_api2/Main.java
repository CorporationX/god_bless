package school.faang.stream_api.bjs2_70913.stream_api2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Set<Integer> nums = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toSet());
        int target = 16;
        log.info("unique pairs with sum = {} : {}", target, ListOperations.findUniquePairsWithTargetSum(nums, target));

        Map<String, String> countryCapitalMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        log.info("capitals: {}", ListOperations.getCapitalsOfSortedCountries(countryCapitalMap));

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        log.info("strings: {}", ListOperations.findStringsStartingWithSymbolAndSortByLength(strings, 'a'));

        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();
        log.info("numbers converted into binary: {}", ListOperations.convertNumbersToBinaryStrings(numbers));

        List<String> strs = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        log.info("initial strings: {}, alphabet: {} ", strs, alphabet);
        log.info("filtered strings {}", ListOperations.filterStringsContainingAlphabetAndSortByLength(strs, alphabet));

    }
}
