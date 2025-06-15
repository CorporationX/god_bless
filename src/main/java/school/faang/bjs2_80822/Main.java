package school.faang.bjs2_80822;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("damn", "goddamn", "holymoly", "holycow");

        System.out.println("сумма четных чисол: " + ListOfOperations.sumOfEvenNumbers(numbers));
        System.out.println("наибольшее число: " + ListOfOperations.maxNumber(numbers));
        System.out.println("среднее арифметическое: " + ListOfOperations.averageOfNumbers(numbers));
        System.out.println("количество слов начинающихся на 'd' : " + ListOfOperations.amountStringStartWith(strings,
                'd'));
        System.out.println("слова содержащие 'da' : " + ListOfOperations.stringWith(strings, "da"));
        System.out.println("слова по длине символов: " + ListOfOperations.filterStrings(strings));
        System.out.println("сумма чисел равна 50? " + ListOfOperations.allMatchCondition(numbers,
                number -> ListOfOperations.sumOfNumbers(numbers) == 50));
        System.out.println("минимальное число после 5 из списка: " + ListOfOperations.minNumber(numbers, 5));
        System.out.println("длины строк: " + ListOfOperations.mapToStringLength(strings));
    }
}
