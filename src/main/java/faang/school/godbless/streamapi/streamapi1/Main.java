package faang.school.godbless.streamapi.streamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListUtility.sumEvenNumbers(numbers));
        System.out.println("Сумма четных чисел: " + ListUtility.sumEvenNumbers(List.of(1, 3, 5, 7)));

        System.out.println("Максимум: " + ListUtility.findMax(numbers));

        System.out.println("Среднее: " + ListUtility.findAvg(numbers));

        System.out.println("Количество строк, начинающихся на 'a': " + ListUtility.countStringStartWith(strings, 'a'));

        System.out.println("Строки, содержащие 'an': " + ListUtility.filterStringsContainsSubstring(strings, "an"));
        System.out.println("Строки, содержащие 'an': " + ListUtility.filterStringsContainsSubstring(Arrays.asList("An", "ana", null), "an"));

        System.out.println("Отсортированные по длине строки: " + ListUtility.sortByLength(strings));
        System.out.println("Отсортированные по длине строки: " + ListUtility.sortByLength(Arrays.asList("1", "333", null, "4444", "1")));

        System.out.println("Все ли числа чётные? " + ListUtility.allMatchCondition(numbers, n -> n % 2 == 0));

        System.out.println("Наименьшее число больше 4: " + ListUtility.findMinNumberGreaterThan(numbers, 4));

        System.out.println("Длины строк: " + ListUtility.stringsToLengths(strings));
        System.out.println("Длины строк: " + ListUtility.stringsToLengths(Arrays.asList("22", "4444", null, "1", "22", "4444")));
    }
}
