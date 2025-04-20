package school.faang.bjs2_72233;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> setOfNums = Set.of(1, 2, 3, 4, 5, 6);
        int targetNumber = 6;
        log.info("Unique pairs that makes a sum: {}.", Processor.getUniquePairsForTargetSum(setOfNums, targetNumber));

        Map<String, String> countriesCapitals = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        log.info("Capitals sorted by country: {}.", Processor.getCapitalsFromSet(countriesCapitals));

        List<String> strs = List.of("apple", "banana", "avocado", "apricot");
        char ch = 'a';
        log.info("Filtered and sorted strings {}.", Processor.filterByLengthWithParam(strs, ch));

        List<Integer> nums = List.of(1, 2, 3, 4);
        log.info("Converted to binary: {}.", Processor.convertToBinary(nums));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqstuvwxyz";
        log.info("Filtered strings {}.", Processor.filterStringsByAlphabet(words, alphabet));
    }
}
