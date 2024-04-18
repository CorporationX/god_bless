package faang.school.godbless.StreameAPI_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.StreameAPI_2.PairSum.findingPairsOfNumbers;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 5, 3, 6, 4, 5);
        int targetSum = 10;
        List<List<Integer>> pairs = findingPairsOfNumbers(numbers, targetSum);

        System.out.println("Pairs of numbers with sum " + targetSum + " is: " + pairs);
    }
}