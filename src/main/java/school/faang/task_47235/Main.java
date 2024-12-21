package school.faang.task_47235;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "tomato", "pear");

        System.out.println("Сумма четных чисел: " + SetOfMethods.sumOfEvenNumbers(intList));
        System.out.println("Максимум: " + SetOfMethods.getMaxNumber(intList));
        System.out.println("Среднее: : " + SetOfMethods.getArithmeticMean(intList));
        System.out.println("Сколько строк начинается c 'a':" + SetOfMethods.findNumberOfLines(stringList, 'p'));
        System.out.println("Строки, содержащие 'an': " + SetOfMethods.filterStrings(stringList, "an"));
        System.out.println("Отсортированные по длине строки: " + SetOfMethods.sortingByLength(stringList));
        System.out.println("Все ли числа чётные? " + SetOfMethods.allMatch(intList, num -> num % 2 == 0));
        System.out.println("Наименьшее число больше 5: " + SetOfMethods.findMinNumber(intList, 5));
        System.out.println("Длины строк: " + SetOfMethods.convertStringToInt(stringList));
    }
}
