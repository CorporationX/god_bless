package faang.school.godbless.trainingstreamapi1_2634;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {

    static final List<Integer> NUMBERS = new ArrayList<>(List.of(1, 2, 4, 5, 6, 7, 8, 9, 12, 21, 32, 33, 36));
    static final List<String> WORDS = new ArrayList<>(List.of("Dog", "Cat", "Cucumber", "Diligent", "American",
            "Winner", "Computer", "Jeeez", "Loop", "Member"));

    public static void main(String[] args) {
        System.out.println(sumEvenNumbers(NUMBERS));
        System.out.println(getMaxNumber(NUMBERS));
        System.out.println(getAverageNumber(NUMBERS));
        System.out.println(getQuantityOfWordsStartWith('C', WORDS));
        System.out.println(filterWordsContains("ber", WORDS));
        System.out.println(sortWordsByLength(WORDS));
        System.out.println(areAllMatchCondition(NUMBERS, number -> number % 2 == 0));
        System.out.println(areAnyMatchCondition(NUMBERS, number -> number > 10));
        System.out.println(findSmallestElementGreaterThan(10, NUMBERS));
        System.out.println(mapWordsToLength(WORDS));

    }

    public static int sumEvenNumbers(List<Integer> numberList) {
        return numberList.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (number1, number2) -> Integer.sum(number1, number2));
    }

    public static int getMaxNumber(List<Integer> numberList) {
        Optional<Integer> maxOptionalNumber = numberList.stream().max((number1, number2) -> number1 - number2);
        return maxOptionalNumber.orElse(0);
    }

    public static int getAverageNumber(List<Integer> numberList) {
        OptionalDouble averageOptionalNumber = numberList.stream()
                .mapToInt(number -> number)
                .average();
        return (int) averageOptionalNumber.orElse(0.0);
    }

    public static long getQuantityOfWordsStartWith(char letter, List<String> wordList) {
        return wordList.stream()
                .filter(word -> word.charAt(0) == letter)
                .count();
    }

    public static List<String> filterWordsContains(String reference, List<String> wordList) {
        return wordList.stream()
                .filter(word -> word.contains(reference))
                .toList();
    }

    public static List<String> sortWordsByLength(List<String> wordList) {
        return wordList.stream()
                .sorted((word1, word2) -> word1.length() - word2.length())
                .toList();
    }

    public static boolean areAllMatchCondition(List<Integer> numberList, Predicate<Integer> condition) {
        return numberList.stream().allMatch(number -> condition.test(number));
    }

    public static boolean areAnyMatchCondition(List<Integer> numberList, Predicate<Integer> condition) {
        return numberList.stream().anyMatch(number -> condition.test(number));
    }

    public static int findSmallestElementGreaterThan(int greaterThan, List<Integer> numberList) {
        Optional<Integer> optionalMinAbove = numberList.stream()
                .filter(number -> number > greaterThan)
                .min((number1, number2) -> number1 - number2);
        return optionalMinAbove.orElse(0);
    }

    public static List<Integer> mapWordsToLength(List<String> wordList) {
        return wordList.stream()
                .map(word -> word.length())
                .toList();
    }
}
