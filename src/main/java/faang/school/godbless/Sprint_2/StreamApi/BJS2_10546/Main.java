package faang.school.godbless.Sprint_2.StreamApi.BJS2_10546;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма четных чисел: " + sum);

        numbers.stream()
                //Сравнивает числа
                .max(Integer::compare)
                .ifPresent(max -> System.out.println("Максимальный элемент: " + max));

        numbers.stream()
                .mapToInt(Integer::intValue)
                //Вычисляет среднее значение
                .average()
                .ifPresent(avg -> System.out.println("Среднее значение: " + avg));

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "orange");
        long count = strings.stream()
                .filter(s -> s.startsWith("a"))
                .count();
        System.out.println("Количество строк, начинающихся с 'a': " + count);

        List<String> filtered = strings.stream()
                .filter(s -> s.contains("an"))
                .toList();
        System.out.println("Строки, содержащие 'an': " + filtered);

        List<String> sortedByLength = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Отсортированные строки по длине: " + sortedByLength);

        boolean allMatch = numbers.stream()
                //Проверяет условие тру илми фолз
                .allMatch(n -> n > 0);
        System.out.println("Все числа положительные: " + allMatch);

        int threshold = 3;
        numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compare)
                .ifPresent(min -> System.out.println("Наименьший элемент больше " + threshold + ": " + min));

        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();
        System.out.println("Длины строк: " + lengths);
    }

}
