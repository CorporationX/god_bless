package school.faang.bjs2_35254;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(getUniquePairs(listOfNumbers, 7));

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(getListOfCapital(countriesAndCapitals));

        List<String> listOfStrings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println(filterAndSortRows(listOfStrings, 'a'));

        List<Integer> listToConvert = Arrays.asList(1, 2, 3, 4);
        System.out.println(convertNumbersToBinaryFormat(listToConvert));

        List<String> listStringsToSort = Arrays.asList("apple", "banana", "яблоко", "date", "fig", "grape");
        System.out.println(filterStringsAlphabeticallyAndSortByLenght(listStringsToSort, "abcdefghijklmnopqrstuvwxyz"));

        System.out.println(Arrays.toString("fsf".chars().toArray()));
    }

    public static List<String> getUniquePairs(List<Integer> list, int number) {
       return list.stream()
               .filter(n -> n < number)
               .flatMap(a -> list.stream()
                       .filter(b -> a + b == number)
                       .map(b -> "(" + a + ", " + b + ")"))
               .toList();
    }

    public static List<String> getListOfCapital(Map<String, String> mapper) {
      return  mapper.values().stream().toList();
    }

    public static List<String> filterAndSortRows(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryFormat(List<Integer> list) {
       return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringsAlphabeticallyAndSortByLenght(List<String> list, String alphabet) {

        List<Character> validChars = alphabet.chars().mapToObj(c -> (char) c).toList();

        return list.stream()
                .filter(s -> s.chars()
                        .allMatch(c -> validChars.contains((char) c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

}
