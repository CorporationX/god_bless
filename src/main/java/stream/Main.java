package stream;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(CollectionOperations.findPairs(Set.of(1, 2, 3, 4, 5, 6), 6));

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(CollectionOperations.sortCapitals(countriesAndCapitals));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(CollectionOperations.sortStringsStartingWith(fruits, 'a'));

        System.out.println(CollectionOperations.convertToBinary(List.of(1, 2, 3, 4)));

        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(CollectionOperations.sortStrings(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}
