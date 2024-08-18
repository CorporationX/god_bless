package faang.school.godbless.task.stream.api.first.practice;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Mandarin", "Apple", "mango", "Pineapple", "melon", "pepper");
        char letter;
        String substring;
        int minWordLength;

        System.out.println("\nСумма всех четных чисел: " + sumOfEvenNumbers(numbers));

        System.out.println("\nМаксимальный елемент в списке: " + findMaxNumber(numbers));

        System.out.println("\nСреднее значение: " + findAverage(numbers));

        letter = 'm';
        System.out.println("\nКоличество слов на букву '%s' (без учета регистра) равно: %s".
                formatted(letter, findNumberOfWords(words, letter)));

        substring = "apple";
        System.out.println("\nСписок слов с подстрокой '%s' (без учета регистра):".formatted(substring));
        findListOfWords(words, substring).forEach(word -> System.out.println(word));

        System.out.println("\nСписок слов отсортированный по длинне(от меньшего к большему):");
        sortedWordsByLength(words).forEach(word -> System.out.println(word));

        minWordLength = 6;
        System.out.println("\nВсе слова в списке, по длинне меньше или равны 6: " +
                maxLengthOfWordsToMatch(words, minWordLength));

        minWordLength = 5;
        System.out.println("\nНаименьшее, по длинне, слово в списке которое больше %s: "
                .formatted(minWordLength) + findWordByMinLength(words, minWordLength));

        System.out.println("\nСписок из размеров слов по длинне:");
        convertWordsToNumbers(words).forEach(length -> System.out.println(length));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> (number % 2) == 0)
                .reduce(Integer::sum).orElse(0);
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static long findNumberOfWords(List<String> words, char letter) {
        return words.stream()
                .filter(word -> word.toLowerCase().startsWith(Character.toString(letter))).count();
    }

    public static List<String> findListOfWords(List<String> words, String substring) {
        return words.stream().filter(word -> word.toLowerCase().contains(substring)).toList();
    }

    public static List<String> sortedWordsByLength(List<String> words) {
        return words.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean maxLengthOfWordsToMatch(List<String> words, int maxlengthOfWords) {
        return words.stream().allMatch(word -> word.length() <= maxlengthOfWords);
    }

    public static String findWordByMinLength(List<String> words, int minWordLength) {
        return words.stream().filter(word -> word.length() > minWordLength)
                .min(Comparator.comparing(String::length)).orElse(null);
    }

    public static List<Integer> convertWordsToNumbers(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
