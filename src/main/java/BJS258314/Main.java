package BJS258314;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ListOperations operations = new ListOperations();
        final List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4, 7, 5, 6, 7, 8, 9, 10, 33);
        final List<String> listStrings = Arrays.asList("allow", "back", "cyan", "deep", "effect",
                "fake", "bellow", "av", "aba");
        log.info("Summary even numbers: ");
        System.out.println(operations.sumEvenNumbers(listNumbers));
        log.info("Max number: ");
        System.out.println(operations.getMaxNumber(listNumbers));
        log.info("Average number: ");
        System.out.println(operations.getAverage(listNumbers));
        log.info("Numbers string with symbol: ");
        System.out.println(operations.getNumberStringWithSymbol((listStrings), 'a'));
        log.info("Strings with substring: ");
        System.out.println(operations.stringListWithSubstring((listStrings), "low"));
        log.info("Strings sorted: ");
        System.out.println(operations.sortedByLength((listStrings)));
        log.info("Numbers condition : ");
        System.out.println(operations.elementsFilter(listNumbers, i -> i > 1));
        log.info("Min element which more then number : ");
        System.out.println(operations.findMinElementThenGreaterNumber(listNumbers, 4));
        log.info("From string to string length : ");
        System.out.println(operations.stringLength(listStrings));
    }
}
