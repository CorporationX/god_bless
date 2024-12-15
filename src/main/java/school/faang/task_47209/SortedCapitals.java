package school.faang.task_47209;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedCapitals {
    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> capitals = getSortedCapitals(countries);
        System.out.println(capitals);
    }
}