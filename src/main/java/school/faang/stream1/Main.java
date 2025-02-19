package school.faang.stream1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("banana", "strawberry", "blueberry", "watermelon", "apple", "mint");

        System.out.println("The sum of even numbers: " + Operations.findTheSum(numbers));
        System.out.println("Maximum element: " + Operations.findTheMax(numbers));
        System.out.println("The average value: " + Operations.findTheAverage(numbers));
        System.out.println("The number of lines that start with \"s\": " + Operations.findTheNumber(strings, 's'));
        System.out.println("Number of lines that contain \"be\": " + Operations.filterTheList(strings, "be"));
        System.out.println("Strings sorted by length: " + Operations.sortTheList(strings));
        System.out.println("Are all the numbers even? " + Operations.verifyCompliance(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number is greater than 7: " + Operations.findTheSmallestElement(numbers, 7));
        System.out.println("String lengths: " + Operations.convertList(strings));
    }
}
