package trainingstream1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма всех четных чисел: %d \n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимальное число: %d \n", ListOperations.findMax(numbers));
        System.out.printf("Среднее значение: %.2f \n", ListOperations.findAverage(numbers));
        System.out.printf("Кол-во строк, начинающихся с определенного символа: %d \n",
                ListOperations.countStringStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие определенную подстроку: %s \n",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированный список по длине: %s \n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли элементы удовлетворяют условию: %s \n",
                ListOperations.allMatchCondition(numbers, number -> number > 0));
        System.out.printf("Наименьшее число, которое больше переданного: %d \n",
                ListOperations.findMinGreaterThan(numbers, 2));
        System.out.printf("Длины строк: %s \n", ListOperations.convertToLengths(strings));
    }
}
