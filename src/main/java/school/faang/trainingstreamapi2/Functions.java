package school.faang.trainingstreamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Functions {
    public static Map<Integer, Integer> findUniquePairNumbers(Set<Integer> set, int concreteNumber) {
        return null;
    }

    public static List<String> sortCountriesByCapitals(Map<String, String> map) {
        return map.values().stream().sorted().toList();
    }

    public static List<String> filterLinesWithSymbol(List<String> list, char symbol) {
        return list.stream().filter(line -> line.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> transformIntegerToBinaryLine(List<Integer> list) {
        return null;
    }

    public static List<String> filterLinesWithAlphabet(List<String> list, String alphabet) {
        return null;
    }
}
