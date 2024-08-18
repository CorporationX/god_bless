package faang.school.godbless.StreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        int sumOfEvens = sumEvenNumbers(numbers);
        int maxElement = maxElement(numbers);
        double averageNumber = (int) averageNumber(numbers);
        List<Integer> getStringLengths = getStringLengths(numbers);
            System.out.println("Sum of even numbers: " + sumOfEvens);

    }

//    get sum on even numbers
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

//    get max element
    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
    }

//    get average of all numbers in list
    public static double averageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

//    get length af all values in a list from the list
    public static List<Integer> getStringLengths(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> String.valueOf(n).length())
                .collect(Collectors.toList());
    }
}


