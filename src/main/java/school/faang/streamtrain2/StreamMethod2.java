package school.faang.streamtrain2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamMethod2 {
    public static Map<Integer, Integer> getPairsWithSum(Set<Integer> numbers, int sum) {
        Map<Integer, Integer> pairsMap = new HashMap<>();
        numbers.stream()
                .filter(number -> {
                    int complement = sum - number - 1;
                    return number <= complement && numbers.contains(complement);
                })
                .forEach(number -> pairsMap.put(number, sum - number));
        return pairsMap;
    }

    public static List<String> alphabetSortedCapitals(Map<String, String> capitals) {
        return capitals.values().stream()
                .sorted()
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
        return lines.stream()
                .filter(line -> {
                    for (int i = 0; i < line.length(); i++) {
                        if (!alphabet.contains("" + line.charAt(i))) {
                            return false;
                        }
                    }
                    return true;})
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
