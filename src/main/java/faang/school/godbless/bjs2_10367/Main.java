package faang.school.godbless.bjs2_10367;

import java.util.Collections;
import java.util.List;

public class Main {

  private static final String SATISFIES = "Все элементы списка удовлетворяют условию";
  private static final String NO_SATISFIES = "имеетсяэлемент списка не удовлетворяющий условию";
  private static final Integer DIVISOR = 2;
  private static final Integer REMAINDER = 0;

  public static void main(String[] args) {
    System.out.println("Сумма четных чисел: " + findSumEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    System.out.println("Максимальное число: " + findMaximumElement(List.of(17, 12, 38, 4, 50, 6, 71, 88, 9)));
    System.out.println("Среднее значение: " + findAverageValue(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    System.out.println("Коллисество строк начинающихся с опрежеленного символа: " +
        findNumberRows(List.of("Привет", "Пока", "Строка", "Поток", "Буткемп"), "П"));
    System.out.println("Список с одинаковой подстрокой: " +
        getCertainSubstring(List.of("Java позволяет создавать потоки из коллекций",
            "Префиксы в Java могут улучшить читаемость кода",
            "Синхронизация важна при многопоточности",
            "Потоки можно создавать из файлов с помощью Java 8"), "java"));
    System.out.println("Отсортированный список по длине: " +
        sortListStringsLength(List.of("Строка4 Строка4 Строка4 Строка4",
            "Строка3 Строка3 Строка3",
            "Строка1",
            "Строка2 Строка2")));
    System.out.println(checkTheListByCondition(List.of("java", "java", "java"), 4));
    System.out.println("Наименьший элемент в списке, который больше заданного числа: " +
        findSmallestElementInList(List.of(2,5,11,13,20, 7), 8));
    System.out.println("Преобразованный список строк в список их длин: " +
        convertListStringsToListTheirLengths(List.of("Руководство по веб-сервисам Java Spring",
            "Java Spring REST Controller",
            "Руководство по веб-сервисам Java Spring",
            "Java")));
  }

  /**
   * Найти сумму четных чисел в списке.
   * @param numbers список чисел
   * @return
   */
  private static int findSumEvenNumbers(List<Integer> numbers) {
    return numbers.stream()
        .filter(num -> num % DIVISOR == REMAINDER)
        .mapToInt(i -> i)
        .sum();
  }

  /**
   * Найти максимальный элемент в списке чисел.
   * @param numbers список чисел
   * @return
   */
  private static int findMaximumElement(List<Integer> numbers) {
    return numbers.stream()
        .max(Integer::compare)
        .get();
  }

  /**
   * Найти среднее значение чисел в списке.
   * @param numbers список чисел
   * @return
   */
  private static double findAverageValue(List<Integer> numbers) {
    return (double) numbers.stream()
        .mapToInt(i -> i)
        .sum() / DIVISOR;
  }

  /**
   * Найти количество строк, начинающихся с определённого символа в списке строк.
   * @param strings список строк
   * @param ch
   * @return
   */
  private static long findNumberRows(List<String> strings, String ch) {
    return strings.stream()
        .map(String::toLowerCase)
        .filter(str -> str.startsWith(ch.toLowerCase()))
        .count();
  }

  /**
   * Отфильтровать список строк и оставить только те, которые содержат определенную подстроку.
   * @param strings список строк
   */
  private static List<String> getCertainSubstring(List<String> strings, String substring) {
    return strings.stream()
        .map(String::toLowerCase)
        .filter(str -> str.contains(substring.toLowerCase()))
        .toList();
  }

  /**
   * Отсортировать список строк по длине.
   * @param strings список строк
   */
  private static List<String> sortListStringsLength(List<String> strings) {
    return strings.stream()
        .sorted(Collections.reverseOrder().reversed())
        .toList();
  }

  /**
   * Проверить, все ли элементы списка удовлетворяют определённому условию.
   * @param strings список строк
   * @param constNumber
   */
  private static String checkTheListByCondition(List<String> strings, Integer constNumber) {
    Boolean isResult =  strings.stream()
        .anyMatch(f -> !constNumber.equals(f.length()));

    return Boolean.TRUE.equals(isResult) ? NO_SATISFIES : SATISFIES;
  }

  /**
   * Найти наименьший элемент в списке, который больше заданного числа.
   * @param numbers список чисел
   * @param constNumber
   */
  private static Integer findSmallestElementInList(List<Integer> numbers, Integer constNumber) {
    return numbers.stream()
        .filter(num -> num < constNumber)
        .min(Integer::compare)
        .get();
  }

  /**
   * Преобразовать список строк в список их длин.
   * @param strings список строк
   */
  private static List<Integer> convertListStringsToListTheirLengths(List<String> strings) {
    return strings.stream()
        .map(String::length)
        .toList();
  }

}
