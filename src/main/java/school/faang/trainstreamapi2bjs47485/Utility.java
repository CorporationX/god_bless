package school.faang.trainstreamapi2bjs47485;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {
    public static List<List<Integer>> findUniquePairs(List<Integer> numbers,
                                                      int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int number : numbers) {
            int complement = target - number;
            if (seen.contains(complement)) {
                List<Integer> pair = Arrays.asList(Math.min(number, complement),
                        Math.max(number, complement));
                pairs.add(pair);
            }
            seen.add(number);
        }
        return new ArrayList<>(pairs);
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings,
                                                    char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings,
                                                       String alphabet) {
        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
