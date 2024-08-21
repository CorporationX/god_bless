package faang.school.godbless.bjs223270;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> words = List.of("Madrid", "Valencia", "Barcelona", "Sevilla", "Santander", "Palencia");
        System.out.println(StreamUtils.sumEvenNumbers(numbers));
        System.out.println(StreamUtils.maxNumber(numbers));
        System.out.println(StreamUtils.meanNumber(numbers));
        System.out.println(StreamUtils.wordsCounter(words, "S"));
        System.out.println(StreamUtils.wordsFilter(words, "nci"));
        System.out.println(StreamUtils.wordsSorter(words));
        System.out.println(StreamUtils.wordsChecker(words, (word) -> word.contains("a")));
        System.out.println(StreamUtils.numbersFilteredMin(numbers, 4));
        System.out.println(StreamUtils.wordsConverter(words));
    }
}
