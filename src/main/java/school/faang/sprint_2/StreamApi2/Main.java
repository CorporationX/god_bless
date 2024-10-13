package school.faang.sprint_2.StreamApi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<String, String> countryMap = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addCountry("Russia", "Moscow");
        main.addCountry("USA", "Washington");
        main.addCountry("Germany", "Berlin");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "avocadoo", "apricot");
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alfavit = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("уникальные пары чисел: " + Operations.findPairs(numbers, 7));
        System.out.println("отсортированные страны: " + Operations.sortCity(main.countryMap));
        System.out.println("отсортированные строки: " + Operations.sortString(strings, 'a'));
        System.out.println("Преобразование чисел в двоичный формат: " + Operations.convertToBinary(numbers));
        System.out.println("Фильтрация строк по алфавиту и сортировка по длине: " + Operations.filterAndSortByLength(fruits, alfavit));
    }

    public void addCountry(String country, String city) {
        countryMap.put(country, city);
    }
}
