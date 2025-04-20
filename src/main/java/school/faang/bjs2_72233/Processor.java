package school.faang.bjs2_72233;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class Processor {
    public static Set<List<Integer>> getUniquePairsForTargetSum(Set<Integer> nums, int target) {
        return nums.stream()
            .filter(i -> i != target - i && nums.contains(target - i))
            .map(i -> Arrays.asList(i, target - i))
            .peek(Collections::sort)
            .collect(Collectors.toSet());
    }

    public static Set<String> getCapitalsFromSet(Map<String, String> countriesCapitals) {
        return countriesCapitals.entrySet().stream()
            .sorted(Entry.comparingByKey())
            .map((set) -> set.getValue())
            .collect(Collectors.toSet());
    }

    public static List<String> filterByLengthWithParam(List<String> strs, char ch) {
        return strs.stream()
            .filter(s -> s.charAt(0) == ch)
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
            .map(i -> String.format("%4s", Integer.toBinaryString(i)).replace(' ', '0'))
            .toList();
    }

    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
            .filter(s -> {
                for (char c : s.toCharArray()) {
                    if (alphabet.indexOf(c) == -1) {
                        return false;
                    }
                }
                return true;
            })
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }
}
