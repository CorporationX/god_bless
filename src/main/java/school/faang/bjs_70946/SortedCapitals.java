package school.faang.bjs_70946;

import java.util.*;

public class SortedCapitals {
    public static List<String> sortCountriesAndCapitals(Map<String, String> countries) {
        TreeMap<String, String> sortedMap = new TreeMap<>(countries);
        return new ArrayList<>(sortedMap.values());
    }

    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        List<String> capitals = sortCountriesAndCapitals(countries);
        System.out.println(capitals);
    }
}
