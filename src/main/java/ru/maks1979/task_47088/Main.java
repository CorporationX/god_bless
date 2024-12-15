package ru.maks1979.task_47088;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + MathTaskClass.sumOfEven(numbers));
        System.out.println("Максимум: " + MathTaskClass.maxOfNums(numbers));
        System.out.println("Среднее: " + MathTaskClass.arithmeticMean(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + MathTaskClass.sumOfStringsBeginsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + MathTaskClass.stringContainsSomeString(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + MathTaskClass.stringLength(strings));
        System.out.println("Все ли числа чётные? "
                + MathTaskClass.stringSort(numbers, number -> number <= 5));
        System.out.println("Наименьшее число больше 4: " + MathTaskClass.minOfNums(numbers, 4));
        System.out.println("Длины строк: " + MathTaskClass.stringLength(strings));
    }
}//

