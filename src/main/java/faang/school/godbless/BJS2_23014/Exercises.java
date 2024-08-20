package faang.school.godbless.BJS2_23014;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercises {
    public static int getEvenSum(List<Integer> numbers){
        return numbers.stream().filter(numb -> numb % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMaxNumb(List<Integer> numbers){
        return numbers.stream().max(Integer::compareTo).orElseThrow(() -> new IllegalArgumentException("No elements"));
    }

    public static double findAverageNumber(List<Integer> numbers){
        return numbers.stream().mapToDouble(numb -> numb).average().orElse(0);
    }

    public static long findWordsStartingWithSpecificChar(List<String> strings, String startingSymbol){
        return strings.stream().filter(string -> string.startsWith(startingSymbol)).count();
    }

    public static List<String> findBySpecificSubstring(List<String> strings, String targetString){
        return strings.stream().filter(string -> string.contains(targetString)).toList();
    }

    public static List<String> sortStringsByLength(List<String> strings){
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkIfAllStringsLengthMoreThan3(List<String> strings, Predicate<String> stringChecker){
        return strings.stream().allMatch(stringChecker::test);
    }

    public static int findLowestNumber(List<Integer> numbers, int min){
        return numbers.stream().sorted().filter(numb -> numb > min).findFirst().orElse(0);
    }

    public static List<Integer> convertStringsToLength(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}
