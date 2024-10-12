package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamingOperations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int targetValue) {
        Set<List<Integer>> uniquePairs = IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .boxed()
                        .map(j -> List.of(numbers.get(i), numbers.get(j)))
                        .filter(pair -> (pair.get(0) + pair.get(1)) == targetValue))
                .collect(Collectors.toSet());
        return uniquePairs;
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        List<String> capitals = countries.values().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return capitals;
    }

    public static List<String> filterAndSort(List<String> values, char firstCharacter) {
        List<String> result = values.stream()
                .filter(str -> str.startsWith(String.valueOf(firstCharacter)))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
        return result;
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        List<String> result = numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
        return result;
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> values, String alphabet) {
        List<String> result = values.stream()
                .filter(str -> str.toLowerCase().chars().allMatch(c -> alphabet.indexOf((char) c) >= 0)) // Преобразование в нижний регистр
                .sorted((s1, s2) -> s1.length() - s2.length()) // Сортировка по длине
                .collect(Collectors.toList());
        return result;
    }
}
