package faang.school.godbless.streamapi1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import static faang.school.godbless.streamapi1.Stream.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> number = List.of(1, 3, 6, 7, 9, 4, 5, 2, 8, 4);
        List<String> words = List.of("Hello", "Root", "Good", "Morning", "Bye", "Fruit", "Hat", "Heart", "Head");

        //sum of even
        int resutOfSum = sumEvenNumbers(number);
        System.out.println("Sum of the even numbers " + resutOfSum);

        //max element
        Optional<Integer> max = findMaxNumber(number);
        if (max.isPresent()) {
            System.out.println("Max of Numbers: " + max.get());
        } else {
            System.out.println("No maximum value found");
        }

        //Average
        double averageDoubleResult = findAverageNumbers(number);
        System.out.println("The result of the average " + averageDoubleResult);

        //number of Strings
        char character = 'H';
        long countWord = countStringsWithStartingCharacter(words, character);
        System.out.println("Count number of words starting with " + character + ": " + countWord);

        //filter
        String substring = "Hea";
        String filterCount = String.valueOf(filterStringsContainingSubstring(words, substring));
        System.out.println("Result of substring Filter method " + filterCount);

        //sort
        String sortResult = sortStringsByLength(words).toString();
        System.out.println("Sorted list " + sortResult);

        //condition
        Predicate<Integer> condition1 = n -> n < 100;
        boolean result = checkContdition(number, condition1);
        System.out.println("Result of Condition method: " + result);

        //min
        int num = 5;
        Optional<Integer> min = findMin(number, num);
        min.ifPresentOrElse(
                value -> System.out.println("Min of Numbers: " + value),
                () -> System.out.println("No miniimum value found")
        );
        //System.out.println("Min element from list after giving the number " + minResult.get());

        //length of string
        List<Integer> resultOfStringToLength = transformListOfWord(words);
        System.out.println("Result of the String to Length of words: " + resultOfStringToLength);
    }
}
