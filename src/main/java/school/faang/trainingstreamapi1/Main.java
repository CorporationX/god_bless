package school.faang.trainingstreamapi1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final List<Integer> LIST_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 10, 9);
    private static final List<String> LIST_LINES = List.of("my", "name", "Giovanni", "is", "Giorgio");
    private static final char SYMBOL = 'G';
    private static final String LINE = "a";
    private static final int FIRST_NUMBER = 11;
    private static final int SECOND_NUMBER = 7;

    public static void main(String[] args) {
        try {
            log.info("Sum even numbers: {}", ListOperations.findSumEvenNumbers(LIST_NUMBERS));
            log.info("Max element: {}", ListOperations.findMaxElement(LIST_NUMBERS));
            log.info("Average value: {}", ListOperations.findAverageValue(LIST_NUMBERS));
            log.info("Count lines: {} starting with char: {}",
                    ListOperations.findCountLinesStartingWithChar(LIST_LINES, SYMBOL), SYMBOL);
            log.info("Lines contains string - {}: {}",
                    LINE, ListOperations.filterListLinesWithConcreteLine(LIST_LINES, LINE));
            log.info("Sorted list with length: {}", ListOperations.sortedListLinesWithLength(LIST_LINES));
            log.info("Is all numbers of list less {}? - {}", FIRST_NUMBER,
                    ListOperations.checkListOfConcreteCondition(LIST_NUMBERS, number -> number < FIRST_NUMBER));
            log.info("Min element which greater number - {}: {}", SECOND_NUMBER,
                    ListOperations.findMinElementWithGreaterNumber(LIST_NUMBERS, SECOND_NUMBER));
            log.info("List lines to list their lengths: {}",
                    ListOperations.transformListLinesToListLengths(LIST_LINES));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }

    }
}
