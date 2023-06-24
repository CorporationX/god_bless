package sprint3.trainer.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint3.stream.training.one.StreamTrainer;

import java.util.List;
import java.util.function.Predicate;

public class StreamTrainerTest {
    private final List<Integer> nums = List.of(1,2,3,4,5);
    private final List<String> strings = List.of("hello amogus", "hello all", "snake", "wild fire", "smoke in plant");
    @Test
    public void shouldReturnSumOfEvenNumbers() {
        int expectedSum = 6;
        int receivedSum = StreamTrainer.findSumOfEvenNumbers(nums);
        Assertions.assertEquals(expectedSum, receivedSum);
    }

    @Test
    public void shouldReturnMaxElementAmongNumbers() {
        int expectedNum = 5;
        int receivedNum = StreamTrainer.findMaxElementAmongNumbers(nums);
        Assertions.assertEquals(expectedNum, receivedNum);
    }

    @Test
    public void shouldReturnAverageNumber() {
        int expectedNum = 3;
        int receivedNum = StreamTrainer.findAverageNumber(nums);
        Assertions.assertEquals(expectedNum, receivedNum);
    }

    @Test
    public void shouldReturnNumberOfLinesWithCertainChar() {
        char firstLetter = 's';
        long expectedCount = 2;
        long receivedCount = StreamTrainer.findNumberOfLinesWithCertainChar(strings, firstLetter);
        Assertions.assertEquals(expectedCount, receivedCount);
    }

    @Test
    public void shouldReturnFilterStringsBySubstring() {
        String substring = "hello";
        List<String> expectedStrings = List.of("hello amogus", "hello all");
        List<String> receivedStrings = StreamTrainer.filterBySubstring(strings, substring);
        Assertions.assertArrayEquals(expectedStrings.toArray(), receivedStrings.toArray());
    }

    @Test
    public void shouldReturnSortedListByLength() {
        List<String> expectedStrings = List.of("snake", "hello all", "wild fire", "hello amogus", "smoke in plant");
        List<String> receivedStrings = StreamTrainer.sortByLength(strings);
        Assertions.assertArrayEquals(expectedStrings.toArray(), receivedStrings.toArray());
    }

    @Test
    public void shouldReturnAnswerAccordingToCondition() {
        Predicate<String> condition = (str) -> str.contains("e");
        boolean expectedAnswer = true;
        boolean receivedAnswer = StreamTrainer.sortByCorrespondenceForAll(strings, condition);
        Assertions.assertEquals(expectedAnswer, receivedAnswer);
    }

    @Test
    public void shouldReturnSmallestElement() {
        int expectedNum = 3;
        int receivedNum = StreamTrainer.findSmallestElementThan(nums, 2);
        Assertions.assertEquals(expectedNum, receivedNum);
    }

    @Test
    public void shouldReturnListOfLength() {
        List<Integer> expectedList = List.of(12,9,5,9,14);
        List<Integer> receivedList = StreamTrainer.convertToLength(strings);
        Assertions.assertArrayEquals(expectedList.toArray(), receivedList.toArray());
    }
}
