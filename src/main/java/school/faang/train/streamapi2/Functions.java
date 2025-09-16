package school.faang.train.streamapi2;

import java.util.*;
import java.util.stream.Collectors;

public class Functions {
    public static Set<List<Integer>> findUniquePairNumber(Set<Integer> numbers, Integer sum) {
        if (numbers == null || sum == null) {
            throw new IllegalArgumentException("Input parameters must not be null");
        }
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

    }

    public static List<String> sortCountry(Map<String, String> countryWithCapital) {
        if (countryWithCapital == null) {
            throw new IllegalArgumentException("Input parameters must not be null");
        }
        return countryWithCapital.values().stream().sorted().toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char symbol) {
        if (strings == null) {
            throw new IllegalArgumentException("Input parameters must not be null");
        }
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumberIntoBinary(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input parameters must not be null");
        }
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null) {
            throw new IllegalArgumentException("Input parameters must not be null");
        }

        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
