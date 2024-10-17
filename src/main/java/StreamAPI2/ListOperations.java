package StreamAPI2;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static List<int[]> getUniquePairs2(List<Integer> numbers, int result) {
        Set<Integer> checkedNumbers = new HashSet<>();

        return numbers.stream()
                .peek(n -> checkedNumbers.add(n))
                .filter(num -> checkedNumbers.contains(num) && num < result - num)
                .map(n -> new int[]{n, result - n})
                .collect(Collectors.toList());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .map(n -> n.getValue())
                .collect(Collectors.toList());
    }

    public static List<String> getValuesStartWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(n -> n.startsWith(String.valueOf(symbol)))
                .sorted((str1, str2) -> str1.length() - str2.length())
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> Integer.toBinaryString(n))
                .collect(Collectors.toList());
    }

    public static List<String> sortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(n -> n.chars().allMatch(ch -> alphabet.contains(String.valueOf((char) ch))))
                .sorted((str1, str2) -> str1.length() - str2.length())
                .collect(Collectors.toList());
    }
}
