package school.faang.streamapitwo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryCapitalSorter {

    public static List<String> getSortedCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
