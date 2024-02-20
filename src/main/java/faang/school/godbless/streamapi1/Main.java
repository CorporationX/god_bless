package faang.school.godbless.streamapi1;

import java.util.List;

import static faang.school.godbless.streamapi1.Stream.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 3, 6, 7, 9, 4, 5, 2, 8, 4);
        List<String> words = List.of("Hello", "Root", "Good", "Morning", "Bye", "Fruit", "Hat", "Heart");

        sumEvenNumbers();
        findMaxNumber();
        findAverageNumbers();
        countNumber();
        filterWords();
        sortWords();
        checkContdition();
        findMin();
        transformListOfWord();
    }
}
