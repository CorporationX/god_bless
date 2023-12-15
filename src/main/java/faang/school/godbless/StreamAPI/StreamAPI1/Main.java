package faang.school.godbless.StreamAPI.StreamAPI1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(1, 3, 8, 10, 4, 9, 21, 16, 13, 25);

        System.out.println("Max value in List: " + maxValue(numberList));

        System.out.println("Sum evens in List: " + sumOfEvenNumbers(numberList));

        System.out.println("Average value in List: " + averageValue(numberList));

        List<String> stringList = Arrays.asList(
                "Hello World!",
                "Java The Best",
                "HyperX",
                "Hamster",
                "Not Easy to Learn Java",
                "English"
        );

        System.out.println("Count lines by char in List: " + countingLineCharAt('h', stringList));

        System.out.println("Found strings bu substring in List: " + findStringsContainsSubstring("Java", stringList));

        System.out.println("Sorted by length List: " + sortByLength(stringList));

        System.out.println("Check List by definite condition: " + checkListByCondition(numberList));

        System.out.println("Min value above definite in List: " + findMinAboveDefinite(9, numberList));

        System.out.println("String List to Length List " + stringListToLengthList(stringList));

    }

    static int sumOfEvenNumbers(List<Integer> numbers) {

        return numbers.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

    }

    static int maxValue(List<Integer> numbers) {

        Optional<Integer> optional = numbers.stream()
                .max(Comparator.comparingInt(number -> number));

        return optional.orElse(0);

    }

    static int averageValue(List<Integer> numbers) {

        return (int) numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);

    }

    static int countingLineCharAt(Character character, List<String> stringList) {

        List<String> lineList = stringList.stream()
                .map(String::toLowerCase)
                .filter(str -> str.charAt(0) == character)
                .toList();

        return lineList.size();

    }

    static List<String> findStringsContainsSubstring(String string, List<String> stringList) {

        return stringList.stream()
                .filter(str -> str.contains(string))
                .toList();

    }

    static List<String> sortByLength(List<String> stringList) {

        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    static boolean checkListByCondition(List<Integer> numbers) {

        return numbers.stream()
                .allMatch(value -> value > 10);

    }

    static int findMinAboveDefinite(Integer definite, List<Integer> numbers) {

        return numbers.stream()
                .filter(value -> value > definite)
                .mapToInt(Integer::intValue)
                .min().orElse(0);

    }

    static List<Integer> stringListToLengthList(List<String> stringList) {

        return stringList.stream()
                .map(String::length)
                .collect(Collectors.toList());

    }
}
