package school.faang.stream1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("banana", "strawberry", "blueberry", "watermelon", "apple", "mint");

        System.out.printf("The sum of even numbers: %d%n", Operations.findTheSum(numbers));
        System.out.printf("Maximum element: %d%n", Operations.findTheMax(numbers));
        System.out.printf("The average value: %.2f%n", Operations.findTheAverage(numbers));
        System.out.printf("The number of lines that start with \"s\": %d%n", Operations.findTheNumber(strings, 's'));
        System.out.printf("Number of lines that contain \"be\": %s%n", Operations.filterTheList(strings, "be"));
        System.out.printf("Strings sorted by length: %s%n", Operations.sortTheList(strings));
        System.out.printf("Are all the numbers even? %b%n", Operations.verifyCompliance(numbers, n -> n % 2 == 0));
        System.out.printf("The smallest number is greater than 7: %d%n", Operations.findTheSmallestElement(numbers, 7));
        System.out.printf("String lengths: %s%n", Operations.convertList(strings));
    }
}
