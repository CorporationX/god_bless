package school.faang.streamapi_two;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6);

        SolutionMethods solutionMethods = new SolutionMethods();
        System.out.println(solutionMethods.findUniquePairs(numbers, 7));
    }
}
