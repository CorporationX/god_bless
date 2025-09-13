package school.faang.bjs2_89330;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {

    public static List<int[]> findPairs(Set<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .map(b -> new int[]{a, b}))
                .filter(pair -> pair[0] + pair[1] == targetSum)
                .filter(pair -> pair[0] < pair[1])
                .collect(Collectors.toList());
    }

    public static List<String> sortCountries(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public static List<String> filter(List<String> strings, char symbol) {
        return strings.stream().filter(s -> s.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convert(List<Integer> values) {
        return values.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return null; // не придумал решения, пробовал, не получилось, хочется от вас небольшую подсказку)
    }
}
