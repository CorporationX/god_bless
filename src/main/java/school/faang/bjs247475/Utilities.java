package school.faang.bjs247475;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utilities {
    private static final Function<Integer, String> decToBin = (decimal) -> {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal = decimal / 2;
        }
        if (binary.isEmpty()) {
            binary.append("0");
        }
        return binary.toString();
    };

    public static Set<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, Integer target) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);

        pairs = numbers.stream()
                .filter(num -> set.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> getSortedCapitals(Map<String, String> capitalsByCountry) {
        return capitalsByCountry.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLetter(List<String> strings, char letter) {
        return strings.stream().filter(s -> s.startsWith(letter + ""))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> decimalsToBinary(List<Integer> decimals) {
        return decimals.stream()
                .map(decToBin)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> alphabet.chars().anyMatch(c -> s.startsWith((char) c + "")))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }


}
