package school.faang.sprint_2.task_43543;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 7;
        Set<List<Integer>> pairs = ListOperations.findUniquePairsWithSum(integers, sum);
        System.out.println("Уникальные пары с суммой " + sum + ": " + pairs);

        Map<String, String> countries = new HashMap<>();
        countries.put("Франция", "Париж");
        countries.put("Германия", "Берлин");
        countries.put("Италия", "Рим");
        countries.put("Испания", "Мадрид");
        List<String> capitals = ListOperations.getCapitalsSortedByCountry(countries);
        System.out.println("Столицы, отсортированные по странам: " + capitals);

        List<String> strings = Arrays.asList("яблоко", "банан", "вишня", "абрикос", "авокадо");
        char symbol = 'а';
        List<String> filteredAndSorted = ListOperations.filterAndSortByLength(strings, symbol);
        System.out.println("Строки, начинающиеся с '" + symbol + "', отсортированные по длине: " + filteredAndSorted);

        List<Integer> numbers = Arrays.asList(5, 8, 13, 255);
        List<String> binaryStrings = ListOperations.convertIntegersToBinaryStrings(numbers);
        System.out.println("Двоичное представление целых чисел: " + binaryStrings);

        List<String> alphabetStrings = Arrays.asList("яблоко", "банан", "вишня", "киви", "манго");
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщыэюя"; // Все буквы русского алфавита
        List<String> filteredAlphabetStrings = ListOperations.filterAndSortByLengthAlphabet(alphabetStrings, alphabet);
        System.out.println("Строки, содержащие только буквы алфавита, отсортированные по длине: "
                + filteredAlphabetStrings);
    }
}
