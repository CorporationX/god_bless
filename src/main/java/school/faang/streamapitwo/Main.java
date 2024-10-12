package school.faang.streamapitwo;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> firstTask = List.of(1, 2, 3, 4, 5, 6);
        int sum = 7;
        System.out.println("Unique pairs: " + StreamUtils.findPairsBySum(firstTask, sum));

        Map<String, String> secondTask = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Capitals: " + StreamUtils.getCountriesCapitals(secondTask));

        List<String> thirdTask = List.of("apple", "banana", "avocado", "apricot");
        char ch = 'a';
        System.out.println("Filtered strings: " + StreamUtils.getStringsStartingWith(thirdTask, ch));

        List<Integer> fourthTask = List.of(1, 2, 3, 4);
        System.out.println("Binary: " + StreamUtils.convertToBinary(fourthTask));

        List<String> fifthTask = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filtered strings: " + StreamUtils.filterStringsWithAlphabet(fifthTask, alphabet));
    }
}
