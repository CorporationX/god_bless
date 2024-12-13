package school.faang.task_46790;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        log.info("Sum of even numbers: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Maximum: {}", ListOperations.findMax(numbers));
        log.info("Average: {}", ListOperations.findAverage(numbers));
        log.info("Count of strings starting with 'a': {}", ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("Strings containing 'an': {}", ListOperations.filterStringsContainingSubstring("an", strings));
        log.info("Strings sorted by length: {}", ListOperations.sortByLength(strings));
        log.info("Are all numbers even? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));

        Optional<Integer> smallestNumberGreaterThan = ListOperations.findMinGreaterThan(numbers, 4);

        if (smallestNumberGreaterThan.isPresent()) {
            log.info("Smallest number greater than 4: {}", smallestNumberGreaterThan.get());
        } else {
            log.info("The minimum value cannot be found in the null list");
        }

        log.info("Lengths of strings: {}", ListOperations.convertToLengths(strings));
    }
}