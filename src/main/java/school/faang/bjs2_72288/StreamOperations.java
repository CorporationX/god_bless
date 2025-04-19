package school.faang.bjs2_72288;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public Set<IntegerPair> getIntegerPairsMatchingSum(Set<Integer> integers, int targetValue) {
        checkParamsNull(integers);
        return integers.stream()
                .filter(Objects::nonNull)
                .flatMap(value -> integers.stream()
                        .filter(nextValue -> value < nextValue)
                        .map(nextValue -> new IntegerPair(value, nextValue))
                        .filter(pair -> Objects.equals(pair.getSum(), targetValue)))
                .collect(Collectors.toSet());
    }

    public List<String> getCapitals(Map<String, String> countryMap) {
        checkParamsNull(countryMap);
        return countryMap.entrySet().stream()
                .filter(entry -> Objects.nonNull(entry.getKey()))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterByPrefixAndSortStrings(List<String> strings, char ch) {
        checkParamsNull(strings);
        String prefix = String.valueOf(ch).toLowerCase();
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(str -> str.toLowerCase().startsWith(prefix))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> toBinary(List<Integer> integers) {
        checkParamsNull(integers);
        return integers.stream()
                .map(value -> value == null ? null : Integer.toString(value, 2))
                .toList();
    }

    public List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        checkParamsNull(strings);
        checkParamsNull(alphabet);
        Set<Character> alphabetSet = toCharacterSet(alphabet);
        return strings.stream()
                .filter(Objects::nonNull)
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
