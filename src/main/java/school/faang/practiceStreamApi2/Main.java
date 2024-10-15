package school.faang.practiceStreamApi2;

import java.util.List;
import java.util.Map;

public class Main {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public static void main(String[] args) {
    List<Integer> numbers = List.of(
        10, 9, 1, 2, 3, 4, 5, 6, 7, 8
    );

    Map<String, String> countriesAndCapitals = Map.of(
        "Russia", "Moscow",
        "USA", "Washington",
        "Germany", "Berlin"
    );

    List<String> fruits = List.of(
        "apple", "banana", "avocado", "apricot"
    );

    List<String> strings = List.of(
        "apple", "banana", "cherry", "date", "fig", "grape"
    );

    System.out.println(ListOperation.findUniquePairNumbersWithSum(numbers, 9));
    System.out.println(ListOperation.sortCountriesAndGetCapitals(countriesAndCapitals));
    System.out.println(ListOperation.filterByFirstCharAndSortByLength(fruits, 'a'));
    System.out.println(ListOperation.convertIntegersToBinaryStrings(numbers));
    System.out.println(ListOperation.filterByAlphabetAndSortByLength(strings, ALPHABET));
  }
}
