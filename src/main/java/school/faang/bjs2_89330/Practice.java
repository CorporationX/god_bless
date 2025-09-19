package school.faang.bjs2_89330;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {

    public static List<int[]> findPairs(Set<Integer> numbers, int targetSum) {
        List<int[]> result = new ArrayList<>();

        for (Integer num : numbers) {
            int complement = targetSum - num;

            if (numbers.contains(complement)) {
                int min = Math.min(num, complement);
                int max = Math.max(num, complement);

                result.add(new int[]{min, max});
            }

            numbers.add(num);
        }

        return result;
    }

    public static List<String> sortCountries(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).collect(Collectors.toList());
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

        String regex = "^[" + alphabet + "]*$";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }
}
