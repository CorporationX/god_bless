package school.faang.streamAPI;

import java.util.*;

public class CountryCapitals {
    public static List<String> sortCountriesAndCapitals(Map<String, String> countryCapitalMap) {
        List<String> capitals = new ArrayList<>(countryCapitalMap.values());
        Collections.sort(capitals);
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
