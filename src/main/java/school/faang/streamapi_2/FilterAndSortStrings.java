package school.faang.streamapi_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс FilterAndSortStrings
 * Автор: Vital
 * Дата: 23.09.2025
 */

public class FilterAndSortStrings {
    public static List<String> filterAndSort(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}