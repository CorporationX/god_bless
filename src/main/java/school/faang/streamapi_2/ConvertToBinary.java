package school.faang.streamapi_2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс ConvertToBinary
 * Автор: Vital
 * Дата: 23.09.2025
 */

public class ConvertToBinary {
    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}