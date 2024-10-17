package school.faang.bjs2_35668;
import java.util.*;
public class MathMethodUsed {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");



        System.out.println("Sum of even num: " + MathOperation.processNumbers(numbers));
        System.out.println("Max: " + MathOperation.findMaxNumber(numbers));
        System.out.println("Even: " + MathOperation.findAverage(numbers));
        System.out.println("Num of strings, starts with  'a': " + MathOperation.numbersOfCharacters(strings, 'a'));
        System.out.println("Strings, contains 'an': " + MathOperation.filterList(strings, "an"));
        System.out.println("Sorted by length: " + MathOperation.sortedList(strings));
        System.out.println("All numbers even? " + MathOperation.meetAllRequirements(numbers, n -> n % 2 == 0));
        System.out.println("Min number bigger then  4: " + MathOperation.findMinNumber(numbers, 4));
        System.out.println("String length: " + MathOperation.listLength(strings));
    }
}

