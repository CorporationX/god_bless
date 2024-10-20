package school.faang.streamapi;

import java.util.*;

public class CountryCapitals {

    public static List<String> sortCountriesAndCapitals(Map<String, String> countryCapitalMap) {
        List<String> capitals = new ArrayList<>();
        capitals = countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
        return capitals;
    }

    public static void main(String[] args) {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("USA", "Washington");
        countryCapitalMap.put("Germany", "Berlin");

        List<String> result = sortCountriesAndCapitals(countryCapitalMap);
        System.out.println("Sorted capitals: " + result);
    }
}
