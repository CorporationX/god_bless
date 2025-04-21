package school.faang.bjs2_72288;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public Set<IntegerPair> getIntegerPairsMatchingSum(Set<Integer> integers, int targetValue) {
        checkParamsNull(integers);
        integers.forEach(this::checkParamsNull);
        return integers.stream()
                .filter(value -> value * 2 != targetValue && integers.contains(targetValue - value))
                .map(value -> new IntegerPair(value, targetValue - value))
                .collect(Collectors.toSet());
    }

    public List<String> getCapitals(Map<String, String> countryMap) {
        checkParamsNull(countryMap);
        countryMap.keySet().forEach(this::checkParamsNull);
        return countryMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterByPrefixAndSortStrings(List<String> strings, char ch) {
        checkParamsNull(strings);
        strings.forEach(this::checkParamsNull);
        String prefix = String.valueOf(ch).toLowerCase();
        return strings.stream()
                .filter(str -> str.toLowerCase().startsWith(prefix))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> toBinary(List<Integer> integers) {
        checkParamsNull(integers);
        integers.forEach(this::checkParamsNull);
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        checkParamsNull(strings);
        strings.forEach(this::checkParamsNull);
        checkParamsNull(alphabet);
        Set<Character> alphabetSet = toCharacterSet(alphabet);
        return strings.stream()
                .filter(str -> alphabetSet.containsAll(toCharacterSet(str)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private Set<Character> toCharacterSet(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    private <T> void checkParamsNull(T object) {
        if (object == null) {
            throw new ParamsInStreamOperationsIsNullException();
        }
    }
}
