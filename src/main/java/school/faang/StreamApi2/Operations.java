package school.faang.StreamApi2;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {

    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int compare) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.stream()
                .filter((num) -> set.contains(compare - num) && numbers.contains(compare - num))
                .map((num) -> new ArrayList<>(Arrays.asList(num, compare - num)))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char letter) {
        return strings.stream().filter(o -> o.startsWith(String.valueOf(letter))).sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> numbersToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        String regex = "^[" + alphabet + "]+$";
        return strings.stream().filter(s -> s.matches(regex)).sorted(Comparator.comparing(String::length)).toList();
    }
}
