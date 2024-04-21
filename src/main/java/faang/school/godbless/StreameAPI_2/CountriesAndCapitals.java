package faang.school.godbless.StreameAPI_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountriesAndCapitals {
    public static List<String> sortedCountry (Map<String, String> listOfCountryCapitals) {
        return listOfCountryCapitals.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}