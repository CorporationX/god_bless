package streamAPI_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("Потренировали лямбды", "Тренируем стримы", "Затем многопоточка");

        System.out.println("Сумма всех четных элементов в списке: " + getSumOfEvenNumbers(numbers));
        System.out.println("\nСамое большое число в списке: " + getMaxElement(numbers));
        System.out.println("\nСреднее значение чисел в списке: " + getAverageValue(numbers));
        System.out.println("\nКоличество строк которы начинаются с переданного символа " +
                getCountStringsStartingFromTheSymbol(strings, "т"));
        System.out.println("\nЭлемент(ы) списка содержащий(ие) переданную подстроку: ");
        filterStringsThatContainSubstring(strings, "стримы").forEach(System.out::println);
        System.out.println("\nОтсортированный список строк по длине: ");
        sortStringsToLength(strings).forEach(System.out::println);
        System.out.println("\nВсе ли элементы в списке чётные? " +
                (checkListOfElements(numbers, num -> num % 2 == 0) ? "Да." : "Нет."));
        System.out.println("\nНаименьший элемент в списке который больше заданного: "
                + findMinNumberWhichNoMoreThanGivenNumber(numbers, 5));
        System.out.println("\nПреобразованный список стров в список их длин: ");
        convertStringsToLengths(strings).forEach(System.out::println);
    }

    private static int getSumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce((num1, num2) -> num1 + num2)
                .orElse(0);
    }

    private static int getMaxElement(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    private static double getAverageValue(List<Integer> nums) {
        return nums.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    private static long getCountStringsStartingFromTheSymbol(List<String> strings, String symbol) {
        return strings.stream()
                .map(string -> string.toLowerCase())
                .filter(string -> string.startsWith(symbol))
                .count();
    }

    private static List<String> filterStringsThatContainSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    private static List<String> sortStringsToLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static <T> boolean checkListOfElements(List<T> elements, Predicate<T> predicate) {
        return elements.stream()
                .allMatch(predicate);
    }

    private static int findMinNumberWhichNoMoreThanGivenNumber(List<Integer> numbers, int givenNumber) {
        return numbers.stream()
                .filter(num -> num > givenNumber)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    private static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }
}
