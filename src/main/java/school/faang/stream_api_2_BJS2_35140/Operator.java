package school.faang.stream_api_2_BJS2_35140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operator {
    private static final int FIRST_CHARACTER = 0;

    public static Set<List<Integer>> findPairsNumbers(List<Integer> numbers, int numForCompare) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.stream()
                .filter((num) -> numbersSet.contains(numForCompare - num))
                .map((num) -> new ArrayList<>(Arrays.asList(num, numForCompare - num)))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Comparator.comparing(word -> word.getKey().charAt(FIRST_CHARACTER)))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> countries, char letter) {
        return countries.stream()
                .filter((str) -> str.charAt(FIRST_CHARACTER) == letter)
                .sorted(Comparator.comparingInt(String::length))
                .sorted()
                .toList();
    }

    public static List<String> transformationToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortStringsByAlphabet(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }


}
