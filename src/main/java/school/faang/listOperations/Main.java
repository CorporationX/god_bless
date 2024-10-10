package school.faang.listOperations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 4, 2, 5, -1, 9, 4);
        List<String> lines = List.of("Something", "Something bigger", "small", "blabla", "!W!");

        System.out.println("Even numbers sum: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Max: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Lines starting with 'S': " + ListOperations.countLinesWithSymbol(lines, 'S'));
        System.out.println("Lines containing 'ome': " + ListOperations.filterLinesBySubstring(lines, "ome"));
        System.out.println("Lines sorted by their lengths: " + ListOperations.sortByLength(lines));
        System.out.println("Are all the numbers even? " + ListOperations.checkIfAllMatch(numbers, n -> n % 2 == 0));
        System.out.println("Min number which is more than 4: " + ListOperations.findMinMoreThan(numbers, 4));
        System.out.println("Lines lengths: " + ListOperations.mapToLengths(lines));
    }
}
