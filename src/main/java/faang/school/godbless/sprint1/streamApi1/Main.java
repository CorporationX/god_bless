package faang.school.godbless.sprint1.streamApi1;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

  public static void main(String[] args) {
    List<Integer> nums = List.of(11, 3, 49, 21, 23, 15, 0, 1);
    List<String> rows = List.of("Apple", "Banana", "Pear", "Orange", "Bear", "Pineapple");
    char staringChar = 'B';
    String substring = "ea";

    log.info(String.format("Sum even number: %s", Utils.getSumEvenNumbers(nums)));
    log.info(String.format("Max number: %s", Utils.getMaxNumber(nums)));
    log.info(String.format("Average: %s", Utils.getAverage(nums)));
    log.info(String.format("Count starting with %s: %s", staringChar, Utils.getRowCountStartingWith(rows, staringChar)));
    log.info(String.format("With substring %s: %s", substring, Utils.getRowsWithSubstring(rows, substring)));
    log.info(String.format("Sorted strings by length: %s", Utils.sortStringsByLength(rows, true)));
    log.info(String.format("Checked on condition: %s", Utils.checkElementsForCondition(nums, (val) -> val < 100)));
    log.info(String.format("Min number grater than given num: %s", Utils.getMinNumberWithGreaterThanGivenNum(nums, 20)));
    log.info(String.format("Length list: %s", Utils.convertToLengthList(rows)));
  }
}
