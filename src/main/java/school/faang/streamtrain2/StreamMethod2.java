package school.faang.streamtrain2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethod2 {
    public static Map<Integer, Integer> getPairsWithSum(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> {
                    int complement = sum - number - 1;
                    return number <= complement && numbers.contains(complement);
                })
                .collect(Collectors.toMap(
                        number -> number,
                        number -> sum - number
                ));
    }

    public static List<String> alphabetSortedCapitals(Map<String, String> capitals) {
        return capitals.keySet().stream()
                .sorted()
                .map(country -> capitals.get(country))
                .toList();
    }

    public static List<String> sortedLines(List<String> lines, char character) {
        return lines.stream()
                .filter(line -> line.charAt(0) == character)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterLines(List<String> lines, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return lines.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
