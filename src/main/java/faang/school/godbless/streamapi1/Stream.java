package faang.school.godbless.streamapi1;

import java.util.*;
import java.util.stream.*;

public class Stream {
    public static List<Integer> numbers = List.of(1, 3, 6, 7, 9, 4, 5, 2, 8, 4);
    public static List<String> words = List.of("Hello", "Root", "Good", "Morning", "Bye", "Fruit", "Hat", "Heart");

    public static void stream1even() {
        List<Integer> evenNumbers = Collections.singletonList(numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println(evenNumbers);
    }

    public static void stream2max() {
        //alternative method with OptionalInt
        List<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .stream().toList();
        System.out.println(maxNumber);
    }

    public static void stream3average() {
        OptionalDouble averageNumber = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println(averageNumber);
    }

    public static void stream4count() {
        long countsymbol = words.stream()
                .filter(word -> word.startsWith("H"))
                .collect(Collectors.toList())
                .stream().count();
        System.out.println(countsymbol);
    }

    public static void stream5filter() {
        List<String> wordsOfList = words.stream()
                .filter(word -> word.contains("o"))
                .collect(Collectors.toList());
        System.out.println(wordsOfList);
    }

    public static void stream6sort() {
        List<String> wordsOfList = words.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(wordsOfList);
    }

    public static void stream7condition() {
        boolean minElement = numbers.stream()
                .allMatch(integer -> integer > 0);
        System.out.println(minElement);
    }

    public static void stream8min() {
        List<Integer> minElement = numbers.stream()
                .filter(number -> number > 3)
                .min(Integer::compareTo)
                .stream().toList();
        System.out.println(minElement);
    }

    public static void stream9mapToInt() {
        List<Integer> lengthOfwords = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengthOfwords);
    }
}
