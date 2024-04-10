package faang.school.godbless.StreamApi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = getSum(numbers);
        System.out.println("1. Sum: " + sum);

        int max = getMax(numbers);
        System.out.println("2. Max: " + max);

        OptionalDouble avg = getAvg(numbers);
        System.out.println("3. Avg: " + avg.getAsDouble());

        String text = "The Streams API allows JavaScript to programmatically access streams of data received over the network and process them as desired by the developer";
        char letter = 'a';
        long amountOfWords = getAmountOfWordsThatStartsWithLetter(text, letter);
        System.out.println("4. Amount of words that starts with \"" + letter + "\" is: " + amountOfWords);

        List<String> words = List.of("Seem", "Think", "Fee", "Meet", "Include", "Stargazing", "Astronomy");
        String substring = "ee";
        List<String> wordsThatContainSubstring = getWordsThatContainSubstring(words, substring);
        System.out.println("5. Words that contain substring: \"" + substring + "\" is: " + wordsThatContainSubstring);

        List<String> sortedListByLength = getSortedListByLength(words);
        System.out.println("6. Sorted list by length: " + sortedListByLength);

        boolean checkIsAllWordsGreater = isAllWordsLengthGreaterThan3(words);
        System.out.println("7. Is all words in list greater than 3? : " + checkIsAllWordsGreater);

        String wordWithMinLength = getMinLengthWord(words, 3);
        System.out.println("8. Word with lower length, but greater than 3: " + wordWithMinLength);

        List<Integer> lengthList = mapWordListToWordsLengthList(words);
        System.out.println("9. Words list to words length list: " + lengthList);

    }

    private static int getSum(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int getMax(List<Integer> list) {
        OptionalInt optionalMax = list.stream().mapToInt(Integer::intValue).max();
        return optionalMax.orElse(Integer.MIN_VALUE);
    }

    private static OptionalDouble getAvg(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    private static long getAmountOfWordsThatStartsWithLetter(String text, char letter) {
        return Arrays.stream(text.split("\\s+"))
                .filter(word -> !word.isEmpty() && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(letter))
                .count();
    }

    private static List<String> getWordsThatContainSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .collect(Collectors.toList());
    }

    private static List<String> getSortedListByLength(List<String> words) {
        return words.stream().
                sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private static boolean isAllWordsLengthGreaterThan3(List<String> words) {
        return words.stream().allMatch(word -> word.length() > 3);

    }

    private static String getMinLengthWord(List<String> words, Integer number) {
        Optional<String> minWord = words.stream()
                .filter(word -> word.length() > number)
                .min(Comparator.comparingInt(String::length));

        return minWord.orElse(null);
    }

    private static List<Integer> mapWordListToWordsLengthList(List<String> words) {
        return words.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}