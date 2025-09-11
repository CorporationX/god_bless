package school.faang.bjs2_87900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperation {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> num != target - num && numbers.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getSortedStrings(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> getSortedByAlphabet(List<String> strings, String alphabet) {

        StringBuilder sb = new StringBuilder();
        String regex = sb.append("[")
                .append(alphabet)
                .append("]+").toString();
          return strings.stream()
                  .filter(s->s.matches(regex))
                  .sorted(Comparator.comparing(String::length))
                  .toList();
    }
}
