package school.faang.streamapi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Filters {

    // Поиск уникальных пар чисел, сумма которых равна заданному числу
    public static List<int[]> findUniquePairs(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement) && !used.contains(num) && !used.contains(complement)) {
                result.add(new int[]{complement, num});
                used.add(num);
                used.add(complement);
            }
            seen.add(num);
        }

        return result;
    }

    // Сортировка стран и вывод столиц
    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    // Фильтрация и сортировка строк
    public static List<String> filterAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // Преобразование чисел в двоичный формат
    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    // Фильтрация строк по алфавиту и сортировка по длине
    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char ch : alphabet.toCharArray()) {
            alphabetSet.add(ch);
        }

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
