package faang.school.godbless.Task_16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final List<String> STRINGS = Arrays.asList("war", "warrior", "first", "second");
    private static final List<Number> NUMBERS = Arrays.asList(1, 2, 3, 5.6, 4L, 8, 20);
    public static void main(String[] args) {
        System.out.println(evenNumbers());
        maxNumber();
        middleNumber();
        System.out.println(stringsCount());
        stringsWithCertainSubstring();
        stringsSortedByLength();
        stringsSortedByLength();
        checkElement();
        minElementByCondition();
        stringToTheirLength();
    }

    static int evenNumbers() {
        return NUMBERS.stream().
                mapToInt(Number::intValue).
                filter(number -> (number) % 2 == 0).
                reduce(0, Integer::sum);
    }

    static void maxNumber() {
        NUMBERS.stream().mapToInt(Number::intValue).max().ifPresent(System.out::println);
    }

    static void middleNumber() {
        NUMBERS.stream().mapToInt(Number::intValue).average().ifPresent(System.out::println);
    }

    static long stringsCount() {
        return STRINGS.stream().filter(s -> s.startsWith("h")).count();
    }

    static void stringsWithCertainSubstring() {
        STRINGS.stream().filter(s -> s.contains("war")).forEach(System.out::println);
    }

    static void stringsSortedByLength() {
        STRINGS.stream().sorted((Comparator.comparingInt(String::length))).forEach(System.out::println);
    }

    static void checkElement() {
        NUMBERS.stream().mapToInt(Number::intValue).filter(number -> number > 5).forEach(System.out::println);
    }

    static void minElementByCondition() {
        NUMBERS.stream().mapToInt(Number::intValue).filter(number -> number > 5).min().ifPresent(System.out::println);
    }

    static void stringToTheirLength() {
        STRINGS.stream().map(String::length).forEach(System.out::println);
    }
}
