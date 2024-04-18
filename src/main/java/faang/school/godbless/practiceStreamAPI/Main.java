package faang.school.godbless.practiceStreamAPI;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }

    private static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
    }

    private static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .max()
                .getAsInt();
    }

    private static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    private static long numberOfStringsWithNeededLetter(List<String> words, char s) {
        return words.stream()
                .filter(word -> word.charAt(0) == s)
                .count();
    }

    private static List<String> numberOfStringsWithNeededSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(myString -> myString.contains(substring))
                .toList();
    }

    private static List<String> sortListOfStrings(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    private static boolean satisfyingCondition(List<Integer> numbers, int condition) {
        return numbers.stream()
                .allMatch(num -> num > condition);
    }

    private static Optional<Integer> findSmallestNumberBiggerThanGivenNumber(List<Integer> numbers, int givenNumber) {
        return numbers.stream()
                .filter(num -> num > givenNumber)
                .min(Integer::compare);
    }

    private static List<Integer> transformStringsToLenghts(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}