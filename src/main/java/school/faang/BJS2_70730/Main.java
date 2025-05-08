package school.faang.BJS2_70730;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> strings = List.of("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.startsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}

