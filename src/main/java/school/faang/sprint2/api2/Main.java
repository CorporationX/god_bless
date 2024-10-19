package school.faang.sprint2.api2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int num = 7;
        System.out.println("Уникальные пары числе в сумме дающих " + num + ": " + ListOperations.uniquePair(numbers, num));

        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.println("Столицы по отсортированным странам: " + ListOperations.capitalsSortedByCountries(countries));

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        System.out.println("Осортированные строки начинающиеся на '" + symbol + "': " + ListOperations.sortedStrings(strings, symbol));

        List<Integer> numbers2 = List.of(1, 2, 3, 4);
        System.out.println("Числа, преобразованные в двоичный формат " + num + ": " + ListOperations.numToBinary(numbers2));

        List<String> strings2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Строки из данного алфавита, осортированные по длине " + ListOperations.alphabetStrings(strings2, alphabet));
    }
}