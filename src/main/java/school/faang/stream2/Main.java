package school.faang.stream2;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        StreamMethods methods = new StreamMethods();
        Set<Integer> numbersSet = Set.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbersList = List.of(1, 2, 3, 4, 5, 6);
        int number = 6;
        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin");
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        char symbol = 'a';
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(methods.findUniquePairs(numbersSet, number));
        System.out.println(methods.getSortedCapitals(countries));
        System.out.println(methods.filterAndSortByChar(fruits, symbol));
        System.out.println(methods.convertToBinary(numbersList));
        System.out.println(methods.filterAndSortByLength(fruits, alphabet));
    }
}
