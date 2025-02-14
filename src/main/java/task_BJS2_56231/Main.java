package task_BJS2_56231;

import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Integer> NUMBERS = Set.of(1, 2, 3, 4, 5, 6);
    private static final Map<String, String> COUNTRIES = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin");

    public static void main(String[] args) {
        System.out.println(SetOperations.findUniquePairs(NUMBERS, 6));
        System.out.println(SetOperations.sortCapitals(COUNTRIES));

    }
}
