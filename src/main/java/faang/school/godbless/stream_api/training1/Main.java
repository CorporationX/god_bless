package faang.school.godbless.stream_api.training1;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 4, 11, 5, 7, 3, 10);
        List<String> wordList = List.of("AmerOPica", "AbritPOcoscos", "Bob");
        System.out.println(maxNumber(integerList));
        System.out.println(sumEven(integerList));
        System.out.println(averageNumber(integerList));
        System.out.println(countString(wordList, 'A'));
        System.out.println(filterWord(wordList, "PO"));
        System.out.println(filterWordLength(wordList));
        System.out.println(checkFilter(wordList));
        System.out.println(minElement(integerList,5));
        System.out.println(wordLengthList(wordList));
    }

    public static int sumEven(List<Integer> integerList) {
        return integerList.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int maxNumber(List<Integer> integerList) {
        return integerList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static double averageNumber(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(number -> number)
                .average()
                .orElse(0d);
    }

    public static long countString(List<String> wordList, char letter) {
        return wordList.stream()
                .filter(word -> word.toLowerCase().charAt(0) == letter)
                .count();
    }

    public static List<String> filterWord(List<String> wordList, String substring) {
        return wordList.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> filterWordLength(List<String> wordList) {
        return wordList.stream()
                .sorted((word, wordNext) -> word.length() - wordNext.length())
                .toList();
    }

    public static boolean checkFilter(List<String> wordList) {
        return wordList.stream()
                .allMatch(word -> word.length() > 5);
    }

    public static Integer minElement(List<Integer> numberList, Integer beginInt){
        return numberList.stream()
                .filter(integer -> integer > beginInt)
                .sorted((number, numbernext) -> number - numbernext)
                .toList().get(0);
    }

    public static List<Integer> wordLengthList(List<String> numberList){
        return numberList.stream()
                .map(word -> word.length())
                .toList();
    }
}
