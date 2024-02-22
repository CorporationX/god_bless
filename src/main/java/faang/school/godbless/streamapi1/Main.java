package faang.school.godbless.streamapi1;


import java.util.List;
import java.util.Optional;

import static faang.school.godbless.streamapi1.StreamApi.*;

public class Main {
    private static final List<String> listStrings = List.of("last of ass us", "forza", "Miami", "Moldova", "Moscow", "official", "");

    private static final List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 6, 7, 16, 17, 18, 19, 20, 8, 9, 10,14,15,63);

    public static void streamAPI1() {
        Optional<Integer> sumNumbers = sumEvenNumbers(listNumbers);
        sumNumbers.ifPresent(System.out::println);
    }

    public static void streamAPI2() {
        Optional<Integer> maxNumber = findMaxNumber(listNumbers);
        maxNumber.ifPresent(System.out::println);
    }

    public static void streamAPI3() {
        Optional<Integer> sumNumber = findAvgNumber(listNumbers);
        sumNumber.ifPresent(sum -> System.out.println( sum / listNumbers.size()));
    }

    public static void streamAPI4() {
        System.out.println(countStringsWithStartingCharacter(listStrings, 'm'));
    }

    public static void streamAPI5() {
        filterStringsContainingSubstring(listStrings, "of").forEach(System.out::println);
    }

    public static void streamAPI6() {
        sortStringsByLength(listStrings).forEach(System.out::println);
    }

    public static void streamAPI7() {
        System.out.println(checkingListForACondition(listStrings, "of"));
    }

    public static void streamAPI8() {
        Optional<Integer> smallestElement = findSmallestElementGreaterThan(listNumbers, 5);
        smallestElement.ifPresent(System.out::println);
    }

    public static void streamAPI9() {
        convertStringsToLengths(listStrings).forEach(System.out::println);
    }
}