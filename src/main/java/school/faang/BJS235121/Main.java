package school.faang.BJS235121;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<List<Integer>> result = getUniquePairsIntegers(List.of(1, 2, 3, 4, 5, 6), 7);
        System.out.println(result);
        Set<List<Integer>> result2 = getUniquePairsIntegers(List.of(1, 3, 4, 5), 11);
        System.out.println(result2);

        Map<String, String> resultMap = new HashMap<>(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"));
        System.out.println(getCitiesFromCountries(resultMap));
    }
    public static Set<List<Integer>> getUniquePairsIntegers(List<Integer> integerList, int integersSum) {
         return integerList.stream()
                 .filter((i) -> integerList.contains(integersSum - i))
                 .map((i) -> Arrays.asList(i, integersSum - i))
                 .peek(Collections::sort)
                 .collect(Collectors.toSet());
    }

    public static List<String> getCitiesFromCountries(Map<String, String> contriesMap) {
        return contriesMap.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }
}

