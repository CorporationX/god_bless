package school.faang.BJS2_35260;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    // Найдите уникальные пары чисел
    public static List<int[]> findUniquePairs(List<Integer> numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int number : numbers) {
            int complement = target - number;
            if (seen.contains(complement)) {
                int[] pair = new int[]{Math.min(number, complement), Math.max(number, complement)};
                String pairKey = pair[0] + "," + pair[1];
                if (!uniquePairs.contains(pairKey)) {
                    result.add(pair);
                    uniquePairs.add(pairKey);
                }
            }
            seen.add(number);
        }
        return result;
    }

    // Отсортируйте страны и выведите столицы
    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    // Фильтрация и сортировка строк
    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // Преобразование чисел в двоичный формат
    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    // Фильтрация строк по алфавиту и сортировка по длине
    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
