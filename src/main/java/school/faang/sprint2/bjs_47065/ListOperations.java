package school.faang.sprint2.bjs_47065;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {
    public int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int maxNumber(List<Integer> list) {
        return list.stream()
                .max(Integer::compare)
                .get();
    }

    public double avgNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public List<String> countStringsByChar(List<String> list, char symbol) {
        return list.stream()
                .filter(x -> x.startsWith(String.valueOf(symbol)))
                .collect(Collectors.toList());
    }

    public List<String> filterListBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(x -> x.contains(substring))
                .collect(Collectors.toList());
    }

    public List<String> sortedByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
