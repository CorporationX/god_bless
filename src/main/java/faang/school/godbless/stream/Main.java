package faang.school.godbless.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class Main {
    public static List<Integer> integers =
            new ArrayList<>(List.of(1, 4, 9, 121, 45, 100, 22, 9, 0, -3, 2, -43, 1));
    public static List<String> strings =
            new ArrayList<>(List.of("word", "hello", "world", "good", "morning", "JAVA", "C++", "abracadbra"));

    public static void main(String[] args) {

        //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
        int sumOfIntegers = integers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println("Сумма чисел в списке: " + sumOfIntegers);


        //Найти максимальный элемент в списке чисел;
        Optional<Integer> maxOfIntegers = integers.stream()
                .max(Comparator.comparingInt(integer -> integer));

        System.out.println("Максимальный элемент в списке: " +
                maxOfIntegers.orElseThrow(() -> new NoSuchElementException("Максимальный элемент отсутствует")));


        //Найти среднее значение чисел в списке;
        double average = integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Среднее значение отсутствует"));
        System.out.println("Среднее значение чисел в списке: " + average);


        //Найти количество строк, начинающихся с определённого символа в списке строк;
        long count = strings.stream()
                .filter(str -> str.startsWith("a"))
                .count();
        System.out.println("Количество строк, начинающихся с a: " + count);


        //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
        List<String> filteredStrings = strings.stream()
                .filter(str -> str.contains("o"))
                .toList();
        System.out.println("Отфильтрованные строки с подстрокой o: " + filteredStrings);


        //Отсортировать список строк по длине;
        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Отсортированные строки по длине: " + sortedStrings);


        //Проверить, все ли элементы списка удовлетворяют определённому условию;
        boolean noneMatch = strings.stream()
                .noneMatch(String::isEmpty);
        System.out.println("Все элементы списка не пустые: " + noneMatch);


        //Найти наименьший элемент в списке, который больше заданного числа;
        int currentNumber = 100;
        OptionalInt min = integers.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > currentNumber)
                .min();
        System.out.println("Наименьший элемент, который больше " + currentNumber + ": " +
                min.orElseThrow(() -> new NoSuchElementException("Наименьший элемент отсутствует")));


        //Преобразовать список строк в список их длин
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();
        System.out.println("Длины строк: " + lengths);
    }
}
