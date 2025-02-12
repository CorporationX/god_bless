package listoperations;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                17, 42, 3, 58, 29, 77, 10, 91
        );
        List<String> strings = Arrays.asList(
                "avocado",
                "blueberry",
                "coconut",
                "dragonfruit",
                "elderberry",
                "fig",
                "grape"
        );

        log.info("Sum of even numbers: {}",
                ListOperations.sumOfEvenNumbers(numbers));
        log.info("Maximum: {}",
                ListOperations.findMax(numbers));
        log.info("Average: {}",
                ListOperations.findAverage(numbers));
        log.info("Count of strings starting with 'a': {}",
                ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("Strings containing 'berry': {}",
                ListOperations.filterStringsContainingSubstring(strings, "berry"));
        log.info("Strings sorted by length: {}",
                ListOperations.sortByLength(strings));
        log.info("Are all numbers even? {}",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("Smallest number greater than 30: {}",
                ListOperations.findMinGreaterThan(numbers, 30));
        log.info("String lengths: {}",
                ListOperations.convertToLengths(strings));
    }
}
