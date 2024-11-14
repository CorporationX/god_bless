package org.example.service.trainingStream2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamOperations.findPairNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        System.out.println(StreamOperations.getSortedCapitals(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));

        System.out.println(StreamOperations.getWordsContainsSymbol(List.of("apple", "banana", "avocado", "apricort"), 'a'));

        System.out.println(StreamOperations.decimalToBinary(List.of(1, 2, 3, 4)));

        System.out.println(StreamOperations.sortingWordsWhichContainsString(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghigklmnopqrstuvwxyz"
        ));
    }
}
