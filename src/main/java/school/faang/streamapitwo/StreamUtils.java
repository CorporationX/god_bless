package school.faang.streamapitwo;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class StreamUtils {

    public Set<List<Integer>> findPairsBySum(List<Integer> numbers, int sum) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.stream()
                .filter((number) ->  uniqueNumbers.contains(sum - number))
                .map((number) -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> getCountriesCapitals(Map<String, String> countryToCapital) {
        Objects.requireNonNull(countryToCapital, "countryToCapital cannot be null");

        return countryToCapital.keySet().stream()
                .sorted()
                .map(countryToCapital::get)
                .toList();
    }

    public List<String> getStringsStartingWith(List<String> strings, char startChar) {
        Objects.requireNonNull(strings, "strings cannot be null");

        return strings.stream()
                .filter((string) -> !string.isEmpty() && string.charAt(0) == startChar)
                .sorted()
                .toList();
    }

    public List<String> convertToBinary(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterStringsWithAlphabet(List<String> strings, String alphabet) {
        Objects.requireNonNull(strings, "strings cannot be null");
        Objects.requireNonNull(alphabet, "alphabet cannot be null");

        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter((string) -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
