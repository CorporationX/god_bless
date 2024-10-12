package school.BJS2_35153;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (List<Integer> s : uniqueNumberPairs(listOfNumbers, 7)) {
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

        List<String> listOfFruits_2 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "gfaslaКостяПривет"));
        System.out.println(filteringStringsAlphabetically(listOfFruits_2, "abcdefghijklmnopqrstuvwxyz"));
    }


    public static Set<List<Integer>> uniqueNumberPairs(List<Integer> listOfIntegers, int number) {
        Set<Integer> set = new HashSet<>();
        set.addAll(listOfIntegers);
        Set<List<Integer>> result = listOfIntegers.stream().filter(integer -> set.contains(number - integer))
                .map(integer -> Arrays.asList(integer, number - integer))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return result;
    }

    public static List<String> сountryСapitals(Map<String, String> listOfCountriesAndCapitals) {
        return listOfCountriesAndCapitals.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> filteringRows(List<String> listOfStrings, char a) {
        return listOfStrings.stream().filter(line -> line.startsWith(String.valueOf(a)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> сonversionToBinaryCode(List<Integer> listOfIntegers) {
        return listOfIntegers.stream().map(integer -> Integer.toBinaryString(integer)).collect(Collectors.toList());
    }

    public static List<String> filteringStringsAlphabetically(List<String> words, String word) {
//        String regex = "[" + word + "]+";
//        return words.stream().filter(word_n -> word.matches(regex))
//                .sorted(Comparator.comparingInt(String::length)).toList();


        return words.stream().filter(x ->
                {
                    List<String> stringList = Arrays.asList(x.split(""));
                    return stringList.stream().allMatch(word::contains);
                }
        ).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
}