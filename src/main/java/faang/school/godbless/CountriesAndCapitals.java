package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountriesAndCapitals {
    public static List<String> sortingCountriesAndCapitals(Map<String, String> countriesAndCapitals) {
        List<String> listCapitals = countriesAndCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return listCapitals;
    }
}