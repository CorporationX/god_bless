package stream.api.one;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 6, 1, 5, 8, 3);
        List<String> strings = List.of("Dan", "Maria", "Daniela", "Juan", "Jonh");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEven(nums));
        System.out.println("Максимум: " + ListOperations.findMaxElement(nums));
        System.out.println("Среднее: " + ListOperations.calculateAvg(nums));
        System.out.println("Количество строк, начинающихся на 'J': "
                + ListOperations.countStringsStartWithSymbol(strings, 'J'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterByContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortStringsByLenght(strings));
        System.out.println("Все ли числа чётные? "
                + ListOperations.checkIfAllMatch(nums, num -> num < 10 && num % 2 == 0));
        System.out.println("Наименьшее число больше 5: " + ListOperations.findMinGreaterThan(nums, 5));
        System.out.println("Длины строк: " + ListOperations.getStringsLenghtList(strings));
    }
}
