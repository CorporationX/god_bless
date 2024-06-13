package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortCountries {
    public static void main(String[] args) {
        Map<String, String> mapCountries = new HashMap<>() {{
            put("Russia", "Moscow");
            put("Kazakhstan", "Astana");
            put("Armenia", "Yerevan");
            put("UK", "London");
        }};

        var sortedMap = sortCountries(mapCountries);
        System.out.println("\nSORTED COUNTRIES:");
        sortedMap.forEach((country, city) -> System.out.println(country + " :" + city));
    }

    public static Map<String, String> sortCountries(Map<String, String> countries) {
        Map<String, String> resultMap = countries.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));

        List<String> capitals = resultMap.values().stream().toList();
        capitals.forEach(System.out::println);
        return resultMap;
    }
}
