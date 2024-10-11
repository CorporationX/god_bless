package school.faang.streamapione;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamProcessor {

    public static int sumEvenNumbers(List<Integer> numberList){
        return numberList.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaxNumber(List<Integer> numberList) {
        return numberList.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAverageNumber(List<Integer> numberList) {
        return numberList.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static int countNumberOfStringWithSpecialPrefix(List<String> list, char symbol){
        return (int) list.stream().filter(letter -> letter.charAt(0) == symbol).count();
    }

    public static List<String> findStringWithSpecialSubstring(List<String> list, String subString){
        return list.stream().filter(str -> str.contains(subString)).toList();
    }

    public static List<String> sortListByValuesLength(List<String> list){
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkIfNumbersAreCorrect(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().allMatch(predicate);
    }

    public static int findMinNumberButGreaterThanInputNumber(List<Integer> list, int limit){
        return list.stream().filter(num -> num > limit).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> convertStringsToLengthOfStrings(List<String> list){
        return list.stream().map(String::length).toList();
    }
}
