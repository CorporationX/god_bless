package faang.school.godbless.streamapi1;

import java.util.List;

import static faang.school.godbless.streamapi1.StreamApi.*;

public class Main {
    private static final List<String> listStrings = List.of("last of ass us", "forza", "Miami", "Moldova", "Moscow", "official");

    private static final List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 6, 7, 16, 17, 18, 19, 20, 8, 9, 10);

    public static void streamAPI1() {
        System.out.println(sumOfEvenNumbers(listNumbers));
    }

    public static void streamAPI2() {
        System.out.println(maxNumber(listNumbers));
    }

    public static void streamAPI3() {
        System.out.println(avgNumber(listNumbers));
    }

    public static void streamAPI4() {
        System.out.println(findingNumberOfLines(listStrings, 'z'));
    }

    public static void streamAPI5() {
        filteringListOfStrings(listStrings, "of").forEach(System.out::println);
    }

    public static void streamAPI6() {
        filteringStringsByLength(listStrings).forEach(System.out::println);
    }

    public static void streamAPI7() {
        System.out.println(checkingListForACondition(listStrings, "of"));
    }

    public static void streamAPI8() {
        System.out.println(findItemInList(listNumbers, 5));
    }

    public static void streamAPI9() {
        convertStringsToLengths(listStrings).forEach(stringLen -> System.out.println(stringLen));
    }
}