package school.faang.practiceTheStreamAPI1;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

    // Пример использования методов:
    System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
    ListOperations.findMax(numbers).ifPresent(max -> System.out.println("Максимальное число: " + max));
    System.out.println("Среднее: " + ListOperations.findAverage(numbers));
    System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
    System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
    System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
    System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
    ListOperations.findMinGreaterThan(numbers, 4).ifPresent(min -> System.out.println("Наименьшее число больше 4: " + min));
    System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
  }
}
