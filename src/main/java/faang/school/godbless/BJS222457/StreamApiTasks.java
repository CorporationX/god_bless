package faang.school.godbless.BJS222457;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StreamApiTasks {
    public static void findUniqueSum(List<Integer> numbers, int target) {
        List<List<Integer>> uniquePairs = numbers.stream()
                .flatMap(n1 -> numbers.stream()
                        .filter(n2 -> n1 + n2 == target && n1 < n2)
                        .map(n2 -> Arrays.asList(n1, n2))).toList();
                        System.out.println(uniquePairs);
    }

    public static List<String> sortAlphabeticallyAndDisplay(Map<String, String> countryCapital){
        return countryCapital.keySet().stream()
                .sorted(String::compareTo)
                .map(countryCapital :: get)
                .toList();
    }

    public static void sortListByCharAndLength(List<String> strings, String symbol){
        strings.stream().filter(string -> string.startsWith(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(s -> System.out.print(s + " "));
    }


}
