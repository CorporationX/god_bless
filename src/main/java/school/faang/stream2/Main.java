package school.faang.stream2;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 13.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var uniquePairs = Operations.findUniquePairs(Set.of(1, 2, 3, 4, 5), 6);
        System.out.println(uniquePairs);

        var capitalsByCountry = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        var capitals = Operations.getCountriesCapitals(capitalsByCountry);
        System.out.println(capitals);

        var resultStrings = Operations.filterAndSortStrings(List.of("apple", "banana", "avocado", "apricot"), 'a');
        System.out.println(resultStrings);

        var binary = Operations.convertToBinary(List.of(1, 2, 3, 4));
        System.out.println(binary);

        var sortedStrings = Operations.filterAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"
        );
        System.out.println(sortedStrings);
    }
}
