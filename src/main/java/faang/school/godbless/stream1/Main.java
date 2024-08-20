package faang.school.godbless.stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    private static final List<Integer> numsEven = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
    private static final List<String> letters = new ArrayList<>(List.of("Hello", "Good", "Hope", "pro", "just"));

    public static void main(String[] args) {
        int sumEvenNums = numsEven.stream().reduce(0, Integer::sum);
        System.out.println("Sum " + sumEvenNums);

        OptionalInt maxEvenNums = numsEven.stream().mapToInt(Integer::intValue).max();
        maxEvenNums.ifPresent((key) -> System.out.println("Max " + maxEvenNums.getAsInt()));

        OptionalDouble avgEvenNums = numsEven.stream().mapToInt(Integer::intValue).average();
        avgEvenNums.ifPresent((key) -> System.out.println("Avg " + avgEvenNums.getAsDouble()));


        long countLetter = letters.stream().filter(word -> word.startsWith("H")).count();
        System.out.println("count 'H' " + countLetter);


        List<String> filteredLetters = letters.stream().filter(word -> word.contains("pr")).toList();
        System.out.println("filteredLetters 'pr' " + filteredLetters);


        List<String> sortedByLenght = letters.stream().
                sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("sortedByLenght  " + sortedByLenght);


        boolean allMatch = letters.stream()
                .allMatch(letter -> letter.length() > 3);
        System.out.println("allMatch  length()>3" + allMatch);


        OptionalInt num = numsEven.stream().mapToInt(Integer::intValue).filter(a -> a > 3).min();
        num.ifPresent((key) -> System.out.println("min and >3 =   " + num.getAsInt()));


        List<Integer> lengtList = letters.stream().map(String::length).toList();
        System.out.println("lengtList" + lengtList);
    }
}
