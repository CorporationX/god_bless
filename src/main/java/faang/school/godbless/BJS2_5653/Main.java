package faang.school.godbless.BJS2_5653;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 4, 2, 5, 8));
        List<String> randomWords = new ArrayList<>(List.of("Hello2", "Mayo", "Kitten", "Kit", "Jav1a", "Lava", "Mouse"));

        System.out.println("The sum of even numbers: " + Stream.sumEvenNumbers(numbers));
        System.out.println("The max number is: " + Stream.findMaxNumber(numbers).orElse(0));
        System.out.println("The average number is: " + Stream.findAverageNumber(numbers).orElse(0));
        System.out.println("The number of words starting with the 'M' symbol: " + Stream.CountWordsStartingWithSpecificSymbol(randomWords, "M"));
        System.out.println("List of words containing the 'it' substring: " + Stream.FindWordsWithSpecificSubstring(randomWords, "it"));
        System.out.println("The sorted list by length: " + Stream.SortWordsByLength(randomWords));
        System.out.println("Does any of the words contains a number (true or false)? " + Stream.hasANumber(randomWords));
        System.out.println("The smallest number greater than the specific number is: " + Stream.findSmallestNumberGreaterThanSpecificNumber(numbers, 4).orElse(0));
        System.out.println("The list of words' lengths: " + Stream.convertToLengths(randomWords));
    }
}
