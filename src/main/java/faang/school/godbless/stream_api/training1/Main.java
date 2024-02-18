package faang.school.godbless.stream_api.training1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 4, 11, 5, 7, 3, 10);
        List<String> wordList = List.of("AmerOPica", "AbritPOcoscos", "Bob");
        System.out.println(maxNumber(integerList));
        System.out.println(sumEven(integerList));
        System.out.println(averageNumber(integerList));
        System.out.println(countStringsWithStartingCharacter(wordList, 'A'));
        System.out.println(filterStringsContainingSubstring(wordList, "PO"));
        System.out.println(sortStringsByLength(wordList));
        System.out.println(checkAllElements(wordList, string -> string.length() > 5));
        System.out.println(findSmallestElementGreaterThan(integerList,5));
        System.out.println(convertStringsToLengths(wordList));
    }

    public static int sumEven(List<Integer> integerList) {
        return integerList.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int maxNumber(List<Integer> integerList) {
        return integerList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static double averageNumber(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0d);
    }

    public static long countStringsWithStartingCharacter(List<String> wordList, char letter) {
        return wordList.stream()
                .filter(word -> word.toLowerCase().charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> wordList, String substring) {
        return wordList.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> wordList) {
        return wordList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkAllElements(List<String> wordList, Predicate<String> condition) {
        return wordList.stream().allMatch(condition);
    }

    public static Integer findSmallestElementGreaterThan(List<Integer> numberList, Integer beginInt){
        return numberList.stream()
                .filter(integer -> integer > beginInt)
                .sorted(Comparator.naturalOrder())
                .findFirst().orElse(0);
    }

    public static List<Integer> convertStringsToLengths(List<String> numberList){
        return numberList.stream()
                .map(String::length)
                .toList();
    }
}
