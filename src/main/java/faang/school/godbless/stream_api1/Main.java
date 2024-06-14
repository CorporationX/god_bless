package faang.school.godbless.stream_api1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 7, 3, 4, 6, 7, 8, 9, 10);
        List<String> strings = List.of("hi", "best", "work", "be", "behave");

        int evenSum = StreamOperations.evenSum(list);
        System.out.println(evenSum);

        StreamOperations.maxNumber(list).ifPresentOrElse(System.out::println, () -> System.out.println("Provided null Value"));

        StreamOperations.avgNumber(list).ifPresentOrElse(System.out::println, () -> System.out.println("Provided null value"));

        long stringCount = StreamOperations.countStringsStartingWithCharacter(strings, 'b');
        System.out.println(stringCount);

        StreamOperations.remainContaining(strings, "be").forEach(System.out::println);
        System.out.println();

        StreamOperations.sortStringsByLength(strings).forEach(System.out::println);
        System.out.println();

        boolean result = StreamOperations.allMatcher(strings, string -> string.length() > 1 && string.length() < 10);
        System.out.println(result);

        StreamOperations.minGreaterThan(list, 2).ifPresentOrElse(System.out::println, () -> System.out.println("Null"));

        StreamOperations.stringToItsLength(strings).forEach(System.out::println);
    }
}
