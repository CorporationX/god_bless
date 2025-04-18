package stream.api.one;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 6, 1, 5, 8, 3);
        List<String> strings = List.of("Dan", "Maria", "Daniela", "Juan", "Jonh");

        System.out.println("Сумма четных чисел: " + UtilityClass.sumOfEven(nums));
        System.out.println("Максимум: " + UtilityClass.findMaxElement(nums));
        System.out.println("Среднее: " + UtilityClass.calculateAvg(nums));
        System.out.println("Количество строк, начинающихся на 'J': "
                + UtilityClass.countStringsStartWithSymbol(strings, 'J'));
        System.out.println("Строки, содержащие 'an': " + UtilityClass.filterByContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + UtilityClass.sortStringsByLenght(strings));
        System.out.println("Все ли числа чётные? "
                + UtilityClass.checkIfAllMatch(nums, num -> num < 10 && num % 2 == 0));
        System.out.println("Наименьшее число больше 5: " + UtilityClass.findMinGreaterThan(nums, 5));
        System.out.println("Длины строк: " + UtilityClass.getStringsLenghtList(strings));
    }
}
