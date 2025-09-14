package school.faang.bjs2_88033;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Decision {
    public static Set<List<Integer>> findNumbersBySum(Set<Integer> numbers, int requiredSum) {
        return numbers.stream()
                .filter(num -> num != requiredSum - num && numbers.contains(requiredSum - num))
                .map(num -> Arrays.asList(num, requiredSum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitalsByCountries(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsStartWithSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> numbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> selectStringsWithDefiniteLetters(List<String> strings, String letters) {
        String lettersInRegular = "[" + letters + "]+";
        return strings.stream()
                .filter(string -> string.matches(lettersInRegular))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}
