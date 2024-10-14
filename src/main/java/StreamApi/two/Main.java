package StreamApi.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Тестирование UniquePairs
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 7;

        List<int[]> pairs = UniquePairs.findUniquePairs(numbers, targetSum);

        System.out.println("Уникальные пары чисел, сумма которых равна " + targetSum + ":");
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));


        //Тестирование извлечения столиц
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Российская Империя", "Санкт-Петербург");
        countryCapitalMap.put("Гондурас", "Тегусигальпа");
        countryCapitalMap.put("Эфиопия", "Аддис-Абеба");

        List<String> capitals = FindCountryCapitals.finCountryCapitals(countryCapitalMap);

        System.out.println("\nСтолицы стран, отсортированные по названиям стран:");
        capitals.forEach(System.out::println);


        //Тестирование поиска строки по подстроке
        List<String> strings = Arrays.asList("Санкт-Петербург", "Сегусигальпа", "саддись-обедай", "Сочи");
        char character = 'С';

        List<String> resultStrings = FilterStringsByPattern.filterStringsByPattern(strings, character);

        System.out.println("\nСтроки, начинающиеся с '" + character + "', отсортированные по длине:");
        resultStrings.forEach(System.out::println);


        //Тестирование конвертации в двоичный код
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = ConvertToBinary.convertToBinary(numbersList);

        System.out.println("\nЧисла в двоичном формате:");
        binaryStrings.forEach(System.out::println);


        //Тестирование фильтрации и сортировки строк по заданному строковому паттерну
        List<String> stringsToSort = Arrays.asList("питер", "столица", "борщ", "собачечка");
        String alphabet = "абвгдеёждиклмнопрстувхсчшщэюяц";

        List<String> result = StringSortWithFiltering.stringSortWithFiltering(stringsToSort, alphabet);

        System.out.println("Отфильтрованные и отсортированные строки:");
        result.forEach(System.out::println);
    }
}
