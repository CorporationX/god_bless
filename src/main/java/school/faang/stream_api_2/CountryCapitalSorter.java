package school.faang.stream_api_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryCapitalSorter {
    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}