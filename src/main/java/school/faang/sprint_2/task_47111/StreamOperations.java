package school.faang.sprint_2.task_47111;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findPairsWithSumEqualDestinationNum(List<Integer> integers,
                                                                         int destinationNum) {
        HashSet<Object> supportSet = new HashSet<>(integers);
        return integers.stream()
                .filter(integer -> supportSet.contains(destinationNum - integer))
                .map(integer -> Arrays.asList(integer, destinationNum - integer))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortAndGetCountriesCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStings(List<String> strings, char stringFirstLetter) {
        return strings.stream()
                .filter(string -> string.charAt(0) == stringFirstLetter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> decimalToBinaryString(List<Integer> decimals) {
        return decimals.stream()
                .map(decimal -> new BigInteger(String.valueOf(decimal), 10).toString(2))
                .toList();
    }

    public static List<String> filterStringByCustomAlphabetAndSortByLength(List<String> strings,
                                                                           String customAlphabet) {
        String regex = "[" + customAlphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
