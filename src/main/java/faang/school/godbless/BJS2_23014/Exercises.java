package faang.school.godbless.BJS2_23014;

import java.util.List;

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

    public static List findBySpecificString(List<String> strings, String startingSymbol){
        return strings.stream().filter(string -> string.startsWith(startingSymbol)).toList();
    }

    public static List sortStrings(List<String> strings){
        return strings.stream().sorted().toList();
    }

    public static boolean checkIfAllHaveSameSize(List<String> strings, int size){
        return strings.stream().allMatch((str) -> str.length() == size);
    }

    public static int findLowestNumb(List<Integer> numbers, int min){
        return numbers.stream().sorted().filter(numb -> numb > min).findFirst().orElse(0);
    }

    public static List convertStringsToLength(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}
