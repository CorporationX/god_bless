package school.faang.StreamAPI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(123, 3222, 13, -4, 345, 86, 34);
        List<String> fruits = Arrays.asList("яблоко", "банан", "апельсин", "виноград", "киви", "манго");
        //проверка на сумму четных чисел в списке
        System.out.println(ListOperations.sumOfEvenNumbers(list));
        //проверка на максимальный элемент в списке чисел
        System.out.println(ListOperations.maxNumbers(list));
        //проверка на среднее арифметическое число списке
        System.out.println(ListOperations.findAverage(list));

        System.out.println(ListOperations.countStringsStartingWith(fruits, 'а'));
    }
}
