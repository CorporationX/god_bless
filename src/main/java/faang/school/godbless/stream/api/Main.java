package faang.school.godbless.stream.api;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(57, 78, 34);
        System.out.println(StreamsInt.CalculatesSumEvenNumbers(numbers));
        System.out.println(StreamsInt.findMaxValue(numbers));
        System.out.println();

        List<String> line = List.of("Joe Black", "Joker", " Do re mi", "July");
        System.out.println(StreamsString.findNumberLineWithSymbol(line, 'j'));
        System.out.println(StreamsString.findLineWithSubstring(line, "re"));
        System.out.println(StreamsString.sortByLength(line));
        System.out.println(StreamsString.checkSatisfactionCondition(line));
        StreamsString.processingOptional(line, 100);
        System.out.println(StreamsString.convertToListOfLength(line));
    }


}
