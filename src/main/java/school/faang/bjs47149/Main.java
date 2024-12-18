package school.faang.bjs47149;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + Processor.sumEven(numbers));
        System.out.println("Максимум: " + Processor.max(numbers));
        System.out.println("Среднее: " + Processor.avg(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + Processor.countStartingWithChar(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + Processor.filterStrings(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + Processor.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + Processor.checkAllMatch(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + Processor.minimalMore(numbers, 4));
        System.out.println("Длины строк: " + Processor.mapStringsToLength(strings));
    }

}
