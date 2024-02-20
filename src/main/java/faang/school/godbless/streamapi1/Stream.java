package faang.school.godbless.streamapi1;

import java.util.*;
import java.util.stream.*;

public class Stream {
    public static void sumEvenNumbers() {
        List<Integer> evenNumbers = Collections.singletonList(numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println(evenNumbers);
    }

    public static void findMaxNumber() {
        //alternative method with OptionalInt
        List<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .stream().toList();
        System.out.println(maxNumber);
    }

    public static void findAverageNumbers() {
        OptionalDouble averageNumber = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println(averageNumber);
    }

    public static void countNumber() {
        long countsymbol = words.stream()
                .filter(word -> word.startsWith("H"))
                .collect(Collectors.toList())
                .stream().count();
        System.out.println(countsymbol);
    }

    public static void filterWords() {
        List<String> wordsOfList = words.stream()
                .filter(word -> word.contains("o"))
                .collect(Collectors.toList());
        System.out.println(wordsOfList);
    }

    public static void sortWords() {
        List<String> wordsOfList = words.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(wordsOfList);
    }

    public static void checkContdition() {
        boolean minElement = numbers.stream()
                .allMatch(integer -> integer > 0);
        System.out.println(minElement);
    }

    public static void findMin() {
        List<Integer> minElement = numbers.stream()
                .filter(number -> number > 3)
                .min(Integer::compareTo)
                .stream().toList();
        System.out.println(minElement);
    }

    public static void transformListOfWord() {
        List<Integer> lengthOfwords = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengthOfwords);
    }
}
