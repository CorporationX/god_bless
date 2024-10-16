package school.faang.methods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Method {
    public static Set<Pairs> searchPairs(List<Integer> numbers, int point) {
        Set<Pairs> pairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : numbers) {
            int complement = point - num;
            if (seen.contains(complement)) {
                Pairs pair = new Pairs(num, complement);
                pairs.add(pair);
            }
            seen.add(num);
        }
        return pairs;
    }

    public List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> convertBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public List<String> sortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
