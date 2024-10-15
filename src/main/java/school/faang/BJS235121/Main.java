package school.faang.BJS235121;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

        System.out.println(getFilterSortStringList(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(toBinaryIntegerList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(getFilterAlfavitStringList(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }
    public static Set<List<Integer>> getUniquePairsIntegers(List<Integer> integerList, int integersSum) {
         return integerList.stream()
                 .filter((i) -> integerList.contains(integersSum - i))
                 .map((i) -> Arrays.asList(i, integersSum - i))
                 .peek(Collections::sort)
                 .collect(Collectors.toSet());
    }

    public static List<String> getCitiesFromCountries(Map<String, String> contriesMap) {
        return contriesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> getFilterSortStringList(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(s -> Objects.nonNull(s) && s.charAt(0) == symbol)
                .sorted()
                .toList();
    }

    public static List<String> toBinaryIntegerList(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> getFilterAlfavitStringList(List<String> stringList, String alfavit) {
        Set<Character> characterSet = alfavit.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet());
        return stringList.stream()
                .filter(s -> s.chars()
                        .allMatch(c -> characterSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

