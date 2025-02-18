package school.faang.stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Stream stream = new Stream();
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, -2, 0);
        System.out.println(Arrays.toString(stream.findUniqueNumberPairs(numbers, 4).toArray()));
        System.out.println(Arrays.toString(stream.convertIntegerToBinary(numbers).toArray()));

        Map<String, String> countriesCity = Map.of("Russia", "Moscow",
                "USA", "Washington", "Germany", "Berlin");
        System.out.println(Arrays.toString(stream.sortCountryCapitalsList(countriesCity).toArray()));

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date",
                "fig", "grape", "avocado", "apricot");
        System.out.println(Arrays.toString(stream.filterWordsByInitialLetterSortBySize(fruits, 'a').toArray()));
        System.out.println(Arrays.toString(stream.filterWordsBySetOfLetterSortBySize(fruits, "acdefghijklmnopqrstuwxyz")
                .toArray()));
    }
}
