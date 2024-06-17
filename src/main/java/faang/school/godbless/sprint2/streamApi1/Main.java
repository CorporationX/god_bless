package faang.school.godbless.sprint2.streamApi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(-5);
        nums.add(6);
        nums.add(8);

        System.out.println(StreamCalculation.calculateSumOfOrphan(nums));

        Optional<Integer> maxNUmber = StreamCalculation.getMaxNUmber(nums);
        maxNUmber.ifPresent((num) -> System.out.println("max number: " + num));

        OptionalDouble averageValue = StreamCalculation.getAverageValue(nums);
        averageValue.ifPresent((num) -> System.out.println("Average value: " + averageValue.getAsDouble()));


        List<String> strings = new ArrayList<>();
        strings.add("bcej");
        strings.add("bdf");
        strings.add("ade");
        strings.add("a");

        Long count = StreamCalculation.getCountStringsStartsFromSymbol(strings, "a");
        System.out.println("count of string starts from symbol: " + count);

        List<String> stringsBySubstring = StreamCalculation.getSortedStringsBySubstring(strings, "d");
        System.out.println("list by substring: " + stringsBySubstring);

        List<String> sortedStringsByLength = StreamCalculation.getSortedStringsByLength(strings);
        System.out.println("list by length: " + sortedStringsByLength);

        boolean result = StreamCalculation.checkIfAllMatch(nums, (num) -> num < 10);
        System.out.println("all nums are bigger less than 10: " + result);

        Optional<Integer> theSmallestThatBiggerSomeValue = StreamCalculation.findTheSmallestThatBiggerSomeValue(nums, 5);
        theSmallestThatBiggerSomeValue.ifPresent((num) -> System.out.println("the smallest value than bigger 5: " + num));

        List<Integer> integerList = StreamCalculation.mapToLengthList(strings);
        System.out.println("converted integer list: " + integerList);
    }
}
