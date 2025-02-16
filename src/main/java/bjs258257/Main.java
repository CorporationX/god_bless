package bjs258257;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        LOGGER.info("Sum of even numbers: {}", ListOperations.sumOfEvenNumbers(numbers));
        LOGGER.info("Maximum: {}", ListOperations.findMax(numbers));
        LOGGER.info("Average: {}", ListOperations.findAverage(numbers));
        LOGGER.info("Number of lines starting with 'a': {}",
                ListOperations.countStringsStartingWith(strings, 'a'));
        LOGGER.info("Strings contains 'an': {}",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        LOGGER.info("Sorted by string length: {}", ListOperations.sortByLength(strings));
        LOGGER.info("Are all the numbers even? {}",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        LOGGER.info("The smallest number is greater than 4: {}",
                ListOperations.findMinGreaterThan(numbers, 4));
        LOGGER.info("String lengths: {}", ListOperations.convertToLengths(strings));
    }
}
