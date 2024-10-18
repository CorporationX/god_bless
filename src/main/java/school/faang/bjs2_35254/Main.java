package school.faang.bjs2_35254;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(2, 5, 3, 6, 4, 1);


        System.out.println(getUniquePairs(listOfNumbers, 7));

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(getListOfCapital(countriesAndCapitals));

        List<String> listOfStrings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println(filterAndSortRows(listOfStrings, 'a'));

        List<Integer> listToConvert = Arrays.asList(1, 2, 3, 4);
        System.out.println(convertNumbersToBinaryFormat(listToConvert));

        List<String> listStringsToSort = Arrays.asList("apple", "banana", "яблоко", "date", "fig", "grape");
        System.out.println(filterStringsAlphabeticallyAndSortByLength(listStringsToSort, "abcdefghijklmnopqrstuvwxyz"));

        System.out.println(Arrays.toString("fsf".chars().toArray()));
    }

    public static Set<Set<Integer>> getUniquePairs(List<Integer> list, int number) {
       return list.stream()
               .filter(element ->  list.contains(number - element))
               .map(element -> Set.of(element, number - element))
               .collect(Collectors.toSet());
    }

    public static List<String> getListOfCapital(Map<String, String> mapper) {
        return mapper.values().stream().sorted().toList();
    }

    public static List<String> filterAndSortRows(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryFormat(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringsAlphabeticallyAndSortByLength(List<String> list, String alphabet) {
       return list.stream()
                .filter(s -> Pattern.matches("[" + alphabet + "]+", s))
                .sorted(Comparator.comparing(String::length)).toList();
    }
}
