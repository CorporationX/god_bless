package school.faang.practiceTheStreamAPI1;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

    System.out.printf("Сумма четных чисел: %d\n", ListOperations.sumOfEvenNumbers(numbers));
    ListOperations.findMax(numbers).ifPresent(max -> System.out.printf("Максимальное число: %d\n", max));
    System.out.printf("Среднее: %.1f\n", ListOperations.findAverage(numbers));
    System.out.printf("Количество строк, начинающихся на 'a': %d\n", ListOperations.countStringsStartingWith(strings, 'a'));
    System.out.printf("Строки, содержащие 'an': %s\n", ListOperations.filterStringsContainingSubstring(strings, "an"));
    System.out.printf("Отсортированные по длине строки: %s\n", ListOperations.sortByLength(strings));
    System.out.printf("Все ли числа чётные? %s\n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
    ListOperations.findMinGreaterThan(numbers, 4).ifPresent(min -> System.out.printf("Наименьшее число больше 4: %d\n", min));
    System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(strings));
  }
}
