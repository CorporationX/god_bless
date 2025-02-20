package school.faang.naughtwoBJS258161;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        Map<Integer, Integer> result = CollectionOperations.findPairsOfNumbers(numbers, 7);
        System.out.println(result.toString());

        Set<String> binaryNumbers = CollectionOperations.convertingToBinary(numbers);
        System.out.println(binaryNumbers);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        List<String> capitals = CollectionOperations.sortCountriesAndReturnCapitals(countries);
        System.out.println(capitals.toString());

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("avocado");
        fruits.add("apricot");
        List<String> fruitsA = CollectionOperations.filterAndSortStrings(fruits, 'a');
        System.out.println(fruitsA.toString());

        List<String> fruitsSort = CollectionOperations.filterByAlphabetAndSortByLength(fruits, "abn");
        System.out.println(fruitsSort.toString());
    }
}
