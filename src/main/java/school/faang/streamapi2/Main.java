package school.faang.streamapi2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        Map<String, String> mapCountries = Map.of("Russia","Moscow",
                                                "USA", "Washington",
                                                "Germany", "Berlin");
        List<String> stringsTaskFive = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        // Пример использования методов:
        System.out.println("Пары чисел, которые в сумме дают " + 7 + ": " +
                                                ListOperations.pairOfNumbersThatUpNumber(numbers, 7));
        System.out.println("Столицы стран, которые отсортированы по алфавиту:" +
                                                ListOperations.sortCountiesPrintCapitals(mapCountries));
        System.out.println("Фильтрация и сортировка строк:" +
                                                ListOperations.filterAndSortStrings(strings, 'a'));
        System.out.println("Представление чисел в двоичном виде:" + ListOperations.numbersToBinaryCode(numbers));
        System.out.println("Фильтрация строк по алфавиту и сортировка по длине:" +
                                                ListOperations.filterAndSortToLenghtString(stringsTaskFive, alphabet));
    }
}