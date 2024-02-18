package stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class practiceStream {

    public static int sumNumbers(List<Integer> saveTheNumbers) {
        return saveTheNumbers.stream().
                filter(numbers -> numbers % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int maxNumbers(List<Integer> saveTheNumbers) {
        return saveTheNumbers.stream()
                .max(Integer::compareTo).
                orElse(0);
    }

    public static double averageNumbers(List<Integer> saveTheNumbers) {
        return saveTheNumbers.stream().
                mapToInt(Integer::intValue).
                average().
                orElse(0);
    }

    public static boolean searchForSymbol(List<String> saveTheString) {
        return saveTheString.stream().
                allMatch(element -> element.startsWith("K"));
    }

    public static List<String> filterStrings(List<String> saveTheString, String badstring) {
        return saveTheString.stream().
                filter(element -> element.contains(badstring)).
                collect(Collectors.toList());
    }

    public static List<String> sortedLongStrings(List<String> saveTheString) {
        return saveTheString.stream().
                sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean processingByParameter(List<String> saveTheString, Predicate<String> predicate) {
        return saveTheString.stream()
                .allMatch(predicate);
    }

    public static int searchingForMore(List<Integer> saveTheNumbers, int number) {
        return saveTheNumbers.stream().
                filter(element -> element > number).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> conversionString(List<String> saveTheString) {
        return saveTheString.stream().map(String::length).collect(Collectors.toList());
    }
}