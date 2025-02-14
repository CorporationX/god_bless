package school.faang.StreamAPI;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = Arrays.asList(123, 3222, 13, -4, 345, 86, 34);
        List<String> fruits = Arrays.asList("яблоко", "банан", "апельсин", "виноград", "киви", "манго");
        //проверка на сумму четных чисел в списке
        System.out.println(ListOperations.sumOfEvenNumbers(listNumbers));
        //проверка на максимальный элемент в списке чисел
        System.out.println(ListOperations.maxNumbers(listNumbers));
        //проверка на среднее арифметическое число списке
        System.out.println(ListOperations.findAverage(listNumbers));
        // проверка на количество строк
        System.out.println(ListOperations.countStringsStartingWith(fruits, 'а'));
        // проверка на фильтрацию строк
        System.out.println(ListOperations.filterStringsBySubstring(fruits, "ew"));
        // проверка на список строк по длине от меньшей к большей
        System.out.println(ListOperations.sortByLength(fruits));
        // проверка на список строк по длине от большей к меньшей
        System.out.println(ListOperations.sortByLength1(fruits));
        //проверка на условие
        System.out.println(ListOperations.allMatchConditionList(listNumbers, n -> n % 2 == 0));
        //проверка на наименьший элемент в списке, который больше заданного числа.
        System.out.println(ListOperations.findMinGreaterThan(listNumbers, 3));
        //проверка преобразовать список строк в список их длин
        System.out.println(ListOperations.mapToLengths(fruits));
    }
}
