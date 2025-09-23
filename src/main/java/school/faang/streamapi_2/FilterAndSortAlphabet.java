package school.faang.streamapi_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс FilterAndSortAlphabet
 * Автор: Vital
 * Дата: 23.09.2025
 */

public class FilterAndSortAlphabet {
    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}