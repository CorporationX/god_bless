package school.faang.bjs2_88106;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOperations {
    public static List<int[]> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 < num2 && num1 + num2 == sum)
                        .map(num2 -> new int[]{num1, num2}))
                .toList();
    }

    public static List<String> sortCapitals(Map<String, String> capitals) {
        return capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> listLines, char c) {
        return listLines.stream()
                .filter(str -> !str.isEmpty() && str.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
