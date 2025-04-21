package school.faang.streamapitwo;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TrainingStreamApi {

    public static Set<Pair<Integer, Integer>> findUniquePairs(@NonNull Set<Integer> nums, int value) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            int complement = value - n;
            if (seen.contains(complement)) {
                result.add(new Pair<>(min(n, complement), max(n, complement)));
            }
            seen.add(n);
        }
        return result;
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> capitalsByCountries) {
        return capitalsByCountries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByFirstChar(@NonNull List<String> strings, char firstChar) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == firstChar)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryList(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(@NonNull List<String> strings, String alphabet) {
        String charClass = "[" + Pattern.quote(alphabet) + "]";
        Pattern onlyAllowed = Pattern.compile("^" + charClass + "+$");
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && onlyAllowed.matcher(s).matches())
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
