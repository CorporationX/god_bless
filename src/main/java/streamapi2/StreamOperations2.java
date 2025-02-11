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
    private static final String ERR_ALLOWED_ALPHABET_NULL = "Allowed alphabet must not be null";
    private static final String ERR_ALLOWED_ALPHABET_EMPTY = "Allowed alphabet must not be empty";

    public List<Pair> findUniquePairs(Set<Integer> numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_SET_NUMBERS_NULL);
        }
        return numbers.stream()
                .filter(n -> numbers.contains(target - n) && n < (target - n))
                .map(n -> new Pair(n, target - n))
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
        if (strings == null) {
            throw new IllegalArgumentException(ERR_LIST_STRINGS_NULL);
        }
        if (allowedAlphabet == null) {
            throw new IllegalArgumentException(ERR_ALLOWED_ALPHABET_NULL);
        }
        if (allowedAlphabet.isEmpty()) {
            throw new IllegalArgumentException(ERR_ALLOWED_ALPHABET_EMPTY);
        }
        return strings.stream()
                .filter(s -> s != null
                        && !s.isEmpty()
                        && s.chars().allMatch(ch -> allowedAlphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static record Pair(int first, int second) {
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}
