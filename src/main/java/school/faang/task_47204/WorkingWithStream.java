package school.faang.task_47204;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkingWithStream {

    public static Set<List<Integer>> uniquePairsOfNumber(List<Integer> listNumber, int sumNumber) {
        Set<Integer> setNumber = new HashSet<>(listNumber);
        return setNumber.stream()
                .filter(i -> setNumber.contains(sumNumber - i))
                .map(i -> Arrays.asList(i, sumNumber - i))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortingCity(Map<String, String> countryCity) {
        return countryCity.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filteringAndSortingString(List<String> stringList, char firstLetter) {
        return stringList.stream()
                .filter(x -> x.startsWith(String.valueOf(firstLetter)))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static List<String> conversionBinaryFormat(List<Integer> listNumber) {
        return listNumber.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());

    }

    public static List<String> filterStringAlphabeticallyAndLength(List<String> listString, String
            alphabet) {
        String regex = "[" + alphabet + "]+";

        return listString.stream()
                .filter(x -> x.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }


}
