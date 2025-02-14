package school.faang.trainingstreamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Functions {
    public static Set<Set<Integer>> findUniquePairNumbers(Set<Integer> set, int concreteNumber) {
        validateSet(set);
        return set.stream()
                .filter(number -> number != concreteNumber - number && set.contains(concreteNumber - number))
                .sorted().map(number -> Set.of(number, concreteNumber - number)).collect(Collectors.toSet());
    }

    public static List<String> sortCountriesByCapitals(Map<String, String> map) {
        validateMap(map);
        return map.values().stream().sorted().toList();
    }

    public static List<String> filterLinesWithSymbol(List<String> list, char symbol) {
        validateList(list);
        return list.stream().filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> transformIntegerToBinaryLine(List<Integer> list) {
        validateList(list);
        return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterLinesWithAlphabet(List<String> list, String alphabet) {
        validateList(list);
        return list.stream().filter(word -> word.chars()
                        .allMatch(character -> alphabet.contains(String.valueOf((char) character)))).toList();
    }

    private static void validateList(List<?> list) {
        Objects.requireNonNull(list, "Invalid value for list");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    private static void validateSet(Set<Integer> set) {
        Objects.requireNonNull(set, "Invalid value for set");
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Set is empty");
        }
    }

    private static void validateMap(Map<String, String> map) {
        Objects.requireNonNull(map, "Invalid value for map");
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }
    }
}
