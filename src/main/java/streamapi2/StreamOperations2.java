package streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamOperations2 {

    private static final String ERR_SET_NUMBERS_NULL = "Set of numbers must not be null";
    private static final String ERR_MAP_COUNTRY_CAPITAL_NULL = "Country-capital map must not be null";
    private static final String ERR_LIST_STRINGS_NULL = "List of strings must not be null";
    private static final String ERR_LIST_NUMBERS_NULL = "List of numbers must not be null";

    public List<int[]> findUniquePairs(Set<Integer> numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_SET_NUMBERS_NULL);
        }
        return numbers.stream()
                .filter(n -> numbers.contains(target - n) && n < (target - n))
                .map(n -> new int[]{n, target - n})
                .toList();
    }

    public List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        if (countryCapitalMap == null) {
            throw new IllegalArgumentException(ERR_MAP_COUNTRY_CAPITAL_NULL);
        }
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterAndSortStrings(List<String> strings, char ch) {
        if (strings == null) {
            throw new IllegalArgumentException(ERR_LIST_STRINGS_NULL);
        }
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertToBinary(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_LIST_NUMBERS_NULL);
        }
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterStringsByAlphabet(List<String> strings, String allowedAlphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(ch -> allowedAlphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
