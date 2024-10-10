package school.faangSprint2.t9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;
        System.out.println(solution.findUniquePairs(input, target));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(solution.sortAndGetCapitals(countries));

        List<String> fruitsInput = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        System.out.println(solution.filterAndSortStrings(fruitsInput, startChar));

        List<Integer> inputMapBinary = Arrays.asList(1, 2, 3, 4);
        System.out.println(solution.convertToBinary(inputMapBinary));

        List<String> inputForFilterAndSort = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.filterAndSortByAlphabet(inputForFilterAndSort, alphabet));
    }
}