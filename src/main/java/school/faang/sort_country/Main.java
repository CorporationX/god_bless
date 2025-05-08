package school.faang.sort_country;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final Map<String, String> countries = Map.of(
                "Russian", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> capitals = getSortedCapitals(countries);
        capitals.forEach(System.out::println);
    }

    private static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
