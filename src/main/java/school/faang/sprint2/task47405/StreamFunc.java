package school.faang.sprint2.task47405;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFunc {

    public static Set<List<Integer>> getUniquePairs(List<Integer> numbers, int sum) {
        Set<Integer> tempNumbers = new HashSet<>(numbers);

        return numbers.stream()
                .peek(tempNumbers::remove)
                .filter(n -> tempNumbers.contains(sum - n))
                .map(n -> Arrays.asList(n, sum - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCities(Map<String, String> cities) {
        return cities.keySet()
                .stream()
                .sorted()
                .map(cities::get)
                .toList();
    }

    public static List<String> getSelectedStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted()
                .toList();
    }

    public static List<String> numberToBinaryList(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();

    }

    public static List<String> sortStringsByAlphabet(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }


}
