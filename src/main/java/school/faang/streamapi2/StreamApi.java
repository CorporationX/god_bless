package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public static List<List<Integer>> findUniqPairs(List<Integer> integerList, Integer target) {
        return integerList.stream()
                .flatMap(n -> integerList.stream()
                        .filter(m -> n != m && n + m == target)
                        .map(m -> Arrays.asList(Math.min(m, n), Math.max(m,n))))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> sortMapByStream(Map<String, String> stringMap) {
        return stringMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortAndFilter(List<String> stringList, char ch) {
        return stringList
                .stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == ch)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> dexToBinary(List<Integer> integerList) {
        return integerList.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> checkString(List<String> stringList, String alphabet) {
        return stringList
                .stream()
                .filter(str -> str.chars().allMatch(ch -> alphabet.indexOf(ch) >= 0))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}