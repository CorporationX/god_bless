package faang.school.godbless.stream_api_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Сумма чисел = " + getSum(numberList));
        findMaxValue(numberList);
        System.out.println("Среднее значение = " + getAverageValue(numberList));

        List<String> wordList = Arrays.asList("строка", "вторая", "строка", "конец");

        System.out.println("Кол-во слов = " + getCountWordsStartWith(wordList, "в"));
        System.out.println("Содержат подстроку = " + filterBySubstring(wordList, "стр"));
        System.out.println("Сортировка по длине = " + sortedWordsByLength(wordList));
        System.out.println("Все содержат условие = " + isAllHasCondition(wordList, "о"));
        findNextAfterValue(numberList, 3);
        System.out.println("Конвертируем в числа = " + convertWordsToLength(wordList));
    }

    private static int getSum(List<Integer> numberList) {
        return numberList.stream()
                .reduce(0, Integer::sum);
    }

    private static void findMaxValue(List<Integer> numberList) {
        numberList.stream()
                .max(Integer::compare)
                .ifPresentOrElse(
                        value -> System.out.println("Max значение = " + value),
                        () -> System.out.println("Объект равен null")
                );
    }

    private static int getAverageValue(List<Integer> numberList) {
        return (int) numberList.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }

    private static int getCountWordsStartWith(List<String> wordList, String letter) {
        return wordList.stream()
                .filter(word -> word.startsWith(letter))
                .toList()
                .size();
    }

    private static List<String> filterBySubstring(List<String> wordList, String substring) {
        return wordList.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    private static List<String> sortedWordsByLength(List<String> wordList) {
        return wordList.stream()
                .sorted((a, b) -> a.length() - b.length())
                .toList();
    }

    private static boolean isAllHasCondition(List<String> wordList, String substring) {
        return wordList.stream()
                .allMatch(word -> word.contains(substring));
    }

    private static void findNextAfterValue(List<Integer> numberList, int value) {
        numberList.stream()
                .filter(number -> number > value)
                .mapToInt(Integer::intValue)
                .min()
                .ifPresentOrElse(number -> System.out.println("Следующее значение = " + number),
                        () -> System.out.println("Нет значений больше заданного параметра")
                );
    }

    private static List<Integer> convertWordsToLength(List<String> wordList) {
        return wordList.stream()
                .map(String::length)
                .toList();
    }
}
