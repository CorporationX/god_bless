package faang.school.godbless.module.second.stream.one;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Исходный список чисел: " + integers);
        System.out.printf("Сумма четных чисел списка: %d \n", getSumOfEvenNumbers(integers));
        System.out.printf("Максимум списка: %d \n", getMax(integers));
        System.out.printf("Среднее списка: %f \n", getAverage(integers));
        List<String> strings = List.of("Hi", "Privet", "Hello", "Hell", "Kapusta", "Kartoshka");
        System.out.println("Исходный список строк: " + strings);
        String character = "H";
        System.out.printf("Количество строк,начинающихся с символа %s - %d \n",
                          character,
                          getCountOfStringStartingWithCharacter(strings, character)
        );
        String containString = "Hell";
        System.out.printf(
            "Отфильтрованный список строк по вхождению строки: %s \n",
            String.join(",", filterStringByContainValue(strings, containString))
        );
        System.out.printf(
            "Сортированный список строк по длине: %s \n",
            String.join(",", sortStringListByLength(strings))
        );
        System.out.printf(
            "Конвертация списка строк в список их длины: %s \n",
            convertStringListToLengthList(strings)
        );
        System.out.printf(
            "Проверка на совпадение всех строк списка строке %s - %b \n",
            character,
            checkIfAllMatch(strings, (string) -> string.startsWith(character))
        );
        int greaterThan = 5;
        System.out.printf(
            "Получение минимума, большего чем %d - %d",
            greaterThan,
            getMinimumGreaterThan(integers, greaterThan)
        );
    }
    
    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter((number) -> number % 2 == 0)
            .reduce(0, ((oldValue, newValue) -> oldValue += newValue));
    }
    
    public static int getMax(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
    }
    
    public static double getAverage(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
    }
    
    public static long getCountOfStringStartingWithCharacter(List<String> strings, String character) {
        return strings.stream()
            .filter((string) -> string.startsWith(character))
            .count();
    }
    
    public static List<String> filterStringByContainValue(List<String> strings, String contains) {
        return strings.stream()
            .filter((string) -> string.contains(contains))
            .toList();
    }
    
    public static List<String> sortStringListByLength(List<String> strings) {
        return strings.stream()
            .sorted(Comparator.comparing(String::length))
            .toList();
    }
    
    public static boolean checkIfAllMatch(List<String> strings, Predicate<String> predicate) {
        return strings.stream().allMatch(predicate);
    }
    
    public static int getMinimumGreaterThan(List<Integer> numbers, int greaterThan) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .filter((integer) -> integer > greaterThan)
            .min()
            .orElse(0);
    }
    
    public static List<Integer> convertStringListToLengthList(List<String> strings) {
        return strings.stream()
            .map((string) -> string.length())
            .toList();
    }
}


