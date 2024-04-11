package faang.school.godbless.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> strings = List.of("aaa", "Aaatyu", "bbb", "ccca");

        System.out.println(CalculateSumOfEvenNumbers(numbers));
        System.out.println(getMaxNumber(numbers));
        System.out.println(getAverageValue(numbers));
        System.out.println(checkListElements(numbers, (number) -> number % 2 == 1));
        System.out.println(getMinNumberWhichMoreThanGivenNumber(numbers, 3));

        System.out.println(getAmountOfLinesStartingWithCertainCharacter(strings, "a"));
        System.out.println(getListContainingSpecificSubstring(strings, "a"));
        System.out.println(sortListByLengthOfString(strings));
        System.out.println(convertListOfStringsToListOfTheirLengths(strings));
    }

    public static int CalculateSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static double getAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static int getAmountOfLinesStartingWithCertainCharacter(List<String> strings, String symbol) {
        return (int) strings.stream()
                .map(String::toLowerCase)
                .filter(string -> string.startsWith(symbol))
                .count();
    }

    public static List<String> getListContainingSpecificSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortListByLengthOfString(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkListElements(List<T> list, Predicate<T> condition) {
        return list.stream().allMatch(condition);
    }

    public static int getMinNumberWhichMoreThanGivenNumber(List<Integer> numbers, Integer givenNumber) {
        return numbers.stream()
                .filter(number -> number > givenNumber)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> convertListOfStringsToListOfTheirLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
