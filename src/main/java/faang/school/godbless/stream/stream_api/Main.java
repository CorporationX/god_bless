package faang.school.godbless.stream.stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> words = List.of("bear", "window", "car", "broom", "cat", "cloud", "work", "arch");

        int evenNumbers = getSumOfEvenNumbers(numbers);
        System.out.println("Сумма четных чисел: " + evenNumbers);

        int maxElement = getMaxElement(numbers);
        System.out.println("Max element: " + maxElement);

        double avgElement = getAvgElement(numbers);
        System.out.println("Average element: " + avgElement);

        int countWords = getCountStringsStartingWithChar(words, 'b');
        System.out.println("Count words starting in the letter: " + countWords);

        List<String> strBySubstring = getFilterStringsContainsSubstring(words, "ar");
        System.out.println("Отфильтрованный список строк, которые содержат определенную подстроку: " + strBySubstring);

        List<String> sortStrByLength = getSortStringsBySubstrings(words);
        System.out.println("Отсортированный список строк по длине: " + sortStrByLength);

        boolean bool = allElements(numbers, p -> p > 0);
        System.out.println("Все ли элементы списка удовлетворяют определённому условию: " + bool);

        int minElement = findMinElementGreaterThanNumber(numbers, 3);
        System.out.println("Наименьший элемент в списке, который больше заданного числа: " + minElement);

        List<Integer> listOfLength = redevelopListOfStringsToListOfLength(words);
        System.out.println("Преобразованный список строк в список их длин: " + listOfLength);

    }

    private static List<Integer> redevelopListOfStringsToListOfLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public static int findMinElementGreaterThanNumber(List<Integer> list, int number) {
        return list.stream()
                .filter(element -> element > number)
                .min(Integer::compareTo)
                .orElse(-1);
    }

    public static <T> boolean allElements(List<T> list, Predicate<? super T> predicate) {
        return list.stream().allMatch(predicate);
    }

    private static List<String> getSortStringsBySubstrings(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> getFilterStringsContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static int getCountStringsStartingWithChar(List<String> strings, char startChar) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == startChar)
                .count();
    }

    public static double getAvgElement(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return average.orElse(0.0);
    }

    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(value -> value)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}