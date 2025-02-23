package school.faang.task_BJS2_58375;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 4, 3);
        final List<String> strings = Arrays.asList("apple", "happyfruit", "banana", "cherry");
        final char specificCharacter = 'b';
        final String subString = "pp";
        final Predicate<Integer> predicateDigitsMoreThenOne = x -> x > 1;
        final int threshold = 2;

        //Пример использования метода
        System.out.println("Sum of even numbers: " + ListOperations.calcSumOfEvenNumbers(numbers));
        System.out.println("The maximum in the list: " + ListOperations.findMaxElement(numbers));
        System.out.println("The average number of numbers in the list: "
                + ListOperations.findAverageValueOfNumbers(numbers));
        System.out.println("Elements starting with specific character " + specificCharacter + ": "
                + ListOperations.findElementsStartWithSpecChar(strings, specificCharacter));
        System.out.println("Elements contain specific substring " + subString + ": "
                + ListOperations.filterElementsWithSpecSubstring(strings, subString));
        System.out.println("Sorted list by elements length: " + ListOperations.sortListByElementsLength(strings));
        System.out.println("Is all list elements meet certain cond: "
                + ListOperations.isAllListElementsMeetCertainCond(numbers, predicateDigitsMoreThenOne));
        System.out.println("Min element greater than threshold: "
                + ListOperations.findMinElementGreaterThanThreshold(numbers, threshold));
        System.out.println("Length of elements: "
                + ListOperations.convertToLengths(strings));
    }
}
