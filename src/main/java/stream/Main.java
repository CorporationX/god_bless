package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final int  whole = 7;
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Уникальные пары чисел: " + ListOperationNew.uniquePairsOfNumbers(numbers, whole));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println("Столицы стран из списка: " + ListOperationNew.getSortedCapitals(countries));

        List<String> fruit = Arrays.asList("apple", "banana", "avacado", "apricot");
        System.out.println("Строки начинаются с заданного символа: " + ListOperationNew.getSortedFruit(fruit, 'a'));

        List<Integer> newNumber = Arrays.asList(1, 2, 3, 4);
        System.out.println("Преобразование  в двоичный формат: " + ListOperationNew.convertToBinary(newNumber));

        List<String> fresh = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println("Фильтрация строк по алфавиту: " + ListOperationNew.getSortByFresh(fresh, alphabet));
    }
}
