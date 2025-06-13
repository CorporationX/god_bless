package school.faang.stream1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class StreamLogicTesting {
    public static void main(String[] args) {
        List<Integer> numberslist = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Predicate<Integer> biggerThanZero = number -> number > 0;

        log.info("Sum = {}", StreamLogic.sumOfEvenElement(numberslist));
        log.info("Max = {}", StreamLogic.maxElement(numberslist));
        log.info("Average = {}", StreamLogic.averageNumber(numberslist));
        log.info("All elements bigger than zero = {}",
                StreamLogic.checkingCondition(numberslist, biggerThanZero));
        log.info("The smallest element that is bigger than {} is {}",
                3, StreamLogic.biggerThanSomeNumber(numberslist, 3));



        List<String> linesList = List.of("one", "two", "three", "four", "five", "english", "slash", "bash");
        char symbol = 't';
        String substring = "sh";

        log.info("lines count with a character {} at the beginning = {}", symbol,
                StreamLogic.countLinesStartingChar(linesList, symbol));
        log.info("lines with a substring {} = {}", substring,
                StreamLogic.stringsWithSubstring(linesList, substring));
        log.info("sorted lines = {}", StreamLogic.sortedLines(linesList));
        log.info("lines length = {}", StreamLogic.linesInNumbers(linesList));
    }
}
