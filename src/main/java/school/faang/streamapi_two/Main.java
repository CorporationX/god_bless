package school.faang.streamapi_two;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = Map.of("Russia", "Moscow",
                                                "USA", "Washington",
                                                "Germany","Berlin");
        List<String> fruit = Arrays.asList("apple", "banana", "avocado", "apricot");

        SolutionMethods solutionMethods = new SolutionMethods();
        System.out.println(solutionMethods.findUniquePairs(numbers, 7));
        System.out.println(solutionMethods.sortCapitalByAlphabet(countries));
        System.out.println(solutionMethods.findStringStartingWithCharAndSort(fruit, 'a'));
        System.out.println(solutionMethods.convertIntegerToBinaryString(numbers));

    }
}
