package school.BJS2_35153;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (List<Integer> s : UniqueNumberPairs(listOfNumbers, 7)) {
            System.out.print(s);
        }
        System.out.println();

        Map<String, String> mapWithCountry = new HashMap<>();
        mapWithCountry.put("Russia", "Moscow");
        mapWithCountry.put("USA", "Washington");
        mapWithCountry.put("Germany", "Berlin");
        System.out.println(сountryСapitals(mapWithCountry));

        List<String> listWithFruits = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "apricot"));
        System.out.println(filteringRows(listWithFruits, 'a'));

        System.out.println(сonversionToBinaryCode(listOfNumbers));

        List<String> listOfFruits_2 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "gfasla5"));
        System.out.println(filteringStringsAlphabetically(listOfFruits_2, "abcdefghijklmnopqrstuvwxyz"));
    }


    public static Set<List<Integer>> UniqueNumberPairs(List<Integer> list, int number) {
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        Set<List<Integer>> result = list.stream().filter(x -> set.contains(number - x)).map(x -> Arrays.asList(x, number - x)).peek(Collections::sort).collect(Collectors.toSet());
        return result;
    }

    public static List<String> сountryСapitals(Map<String, String> mappa) {
        Map<String, String> mappa2 = mappa.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        return new ArrayList<>(mappa2.values());
    }

    public static List<String> filteringRows(List<String> list, char a) {
        return list.stream().filter(x -> x.startsWith(String.valueOf(a))).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static List<String> сonversionToBinaryCode(List<Integer> list) {
        return list.stream().map(x -> Integer.toBinaryString(x)).collect(Collectors.toList());
    }

    public static List<String> filteringStringsAlphabetically(List<String> list, String word) {
        return list.stream().filter(x -> {
                    List<String> stringList = Arrays.asList(x.split(""));
                    return stringList.stream().allMatch(word::contains);
                }
        ).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
}