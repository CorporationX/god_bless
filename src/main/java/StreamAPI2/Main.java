package StreamAPI2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<String> fruits = new ArrayList<>(List.of("apple", "banana", "avocado", "apricot"));
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        ListOperations.getUniquePairs2(numbers, 7).forEach(n -> {
            System.out.println(Arrays.toString(n));
        });

        System.out.println(ListOperations.getCapitals(countries));

        System.out.println(ListOperations.getValuesStartWith(fruits, 'a'));

        System.out.println(ListOperations.convertToBinary(numbers));

        System.out.println(ListOperations.sortByAlphabet(fruits, "abcdefghijklmnopqrstuvwxyz"));
    }
}
