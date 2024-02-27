package streamApi.task1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int evenSum = Stream.evenSum(numbers);
        System.out.println(evenSum);
        Optional<Integer> max = Stream.max(numbers);
        if(max.isPresent()){
            System.out.println(max.get());
        }
        System.out.println(max);
        OptionalDouble average = Stream.average(numbers);
        if(average.isPresent()) {
            System.out.println(average.getAsDouble());
        }
        List<String> strings = List.of("strrrr", "chelsea", "stringsss");
        long countString = Stream.countStringsWithStartingCharacter('s', strings);
        System.out.println(countString);
        List<String> substringList = Stream.filterStringsContainingSubstring("ing", strings);
        System.out.println(substringList);
        Stream.sortStringsByLength(strings);
        Predicate<String> condition = string -> string.length() > 5;
        boolean checkElement = Stream.allMatch(strings, condition);
        System.out.println(checkElement);
        Optional<Integer> min = Stream.findSmallestElementGreaterThan(3, numbers);
        if(min.isPresent()) System.out.println(min.get());
        System.out.println(min);
        List<Integer> sheetLenghts = Stream.convertStringsToLengths(strings);
        System.out.println(sheetLenghts);
    }
}
