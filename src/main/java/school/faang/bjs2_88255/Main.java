package school.faang.bjs2_88255;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers1 = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        List<Integer> numbers2 = List.of(1, 2, 3, 4);
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        System.out.println("Пары чисел, сумма которых равна заданному числу: " +
                ListOperations.findingUniquePairsNumbers(numbers1, 6));
        System.out.println("Сортировка по алфавиту: " +
                ListOperations.sortedCapitals(countries));
        System.out.println("Отфильтрованные строки, начинающиеся с \"а\": " +
                ListOperations.filterAndSortStrings(fruits, 'a'));
        System.out.println("Числа в двоичном формате: " +
                ListOperations.convertToBinary(numbers2));
        System.out.println("Сортировка строк по алфавиту и длине: " +
                ListOperations.filterByAlphabetAndSort(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}