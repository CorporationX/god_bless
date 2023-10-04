package sprint2.magic;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Paris", "France");
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Rome", "Italy");

        Map<String, String> countryCapitalMap = new HashMap<>();
        flipMapToCopy(capitalCountryMap, countryCapitalMap);
        System.out.println(countryCapitalMap);
    }

    private static void flipMapToCopy(Map<String, String> from, Map<String, String> to) {
        for (Map.Entry<String, String> entry : from.entrySet()) {
            to.put(entry.getValue(), entry.getKey());
        }
    }
}