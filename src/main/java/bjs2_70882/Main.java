package bjs2_70882;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        int targetNum = 6;

        System.out.println(MethodsForLists.findUniquePairsOfNumbers(set, targetNum));

        HashMap<String, String> map = new HashMap<>() {{
            put("Russia", "Moscow");
            put("USA", "Washington");
            put("Germany", "Berlin");
        }};

        System.out.println(MethodsForLists.sortingCountriesAndDisplayingCapitals(map));

        List<String> list = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';

        System.out.println(MethodsForLists.filterAndSortTheRows(list, symbol));

        List<Integer> listOfIntegers = List.of(1, 2, 3, 4);

        System.out.println(MethodsForLists.convertToBinaryFormat(listOfIntegers));

        List<String> listOfWord = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(MethodsForLists.filterAlphabeticallyAndSortByLength(listOfWord, alphabet));
    }
}
