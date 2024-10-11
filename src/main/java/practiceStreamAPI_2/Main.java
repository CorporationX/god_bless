package practiceStreamAPI_2;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {
        System.out.println("Найдите уникальные пары чисел: ");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(findUniqPairs(numbers, 7));

        System.out.println("Отсортируйте страны и выведите столицы: ");
        Map<String, String> capitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(sortByKeyAndGetValue(capitals));

        System.out.println("Фильтрация и сортировка строк: ");
        List<String> fruits = List.of("apple", "banana", "orange", "kiwi", "avocado", "mango", "grape");
        System.out.println(filterAndSort(fruits, 'a'));

        System.out.println("Преобразование чисел в двоичный формат: ");
        System.out.println(mapToBinary(numbers));

        System.out.println("Фильтрация строк по алфавиту и сортировка по длине: ");
        System.out.println(filterAndSortByLength(fruits, "abcdefghijklmnopqrstuvwxyz"));
    }

    private static List<String> filterAndSortByLength(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Set<List<Integer>> findUniqPairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortByKeyAndGetValue(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> list, char letter) {
        return list.stream()
                .filter(s -> s.charAt(0) == letter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }


}
