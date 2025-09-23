package school.faang.streamapi_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс SortCountries
 * Автор: Vital
 * Дата: 23.09.2025
 */

public class SortCountries {
    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}