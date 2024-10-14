package StreamApi.two;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindCountryCapitals {
    public static List<String> finCountryCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
