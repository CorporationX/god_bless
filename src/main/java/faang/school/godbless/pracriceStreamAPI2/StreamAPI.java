package faang.school.godbless.pracriceStreamAPI2;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static Set<List<Integer>> uniqCouplesOfNumbers(List<Integer> numbersList, Integer number) {
        return numbersList.stream()
                .filter(nl -> numbersList.contains(number - nl))
                .map(n -> Arrays.asList(n, number - n))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAlphabetically(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue).toList();
    }

}
