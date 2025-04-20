package school.faang.stream2.streamapipractice2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int targetSum = 6;
        log.info(String.valueOf(handler.findUniquePairs(numbers, targetSum)));

        Map<String, String> capitals = Stream.of(new String[][]{
                {"Russia", "Moscow"},
                {"USA", "Washington"},
                {"Germany", "Berlin"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        log.info(String.valueOf(handler.showCapitalsOfCountriesSortedByAlfabet(capitals)));

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        Character beginning = 'a';
        log.info(String.valueOf(handler.findStringsStartingWith(fruits, beginning)));

        List<Integer> numbersInDecimalSystem = Arrays.asList(1, 2, 3, 4);
        log.info(String.valueOf(handler.getNumbersInBinarySystem(numbersInDecimalSystem)));

        List<String> fruitsAndBerries = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "пончик");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        log.info(String.valueOf(handler.checkLettersAndSortWordsByLength(fruitsAndBerries, alphabet)));
    }
}
