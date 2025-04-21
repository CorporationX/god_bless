package school.faang.sprinttwo.streamapi2;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> cityOfCountrys = Map.ofEntries(
                Map.entry("Russia", "Moscow"),
                Map.entry("USA", "Washington"),
                Map.entry("Germany", "Berlin")
        );
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        List<Integer> listOfPrimeNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> testyFruits = List.of("apple", "banana", "cherry", "date", "fig", "grape");


        System.out.printf("Все уникальные пары чисел, сумма которых равна 6: %s%n",
                StreamOperations2.unicPairOfNumbers(numbers, 6));
        System.out.printf("Cписок столиц.: %s%n",
                StreamOperations2.getCapitalOfCountry(cityOfCountrys));
        System.out.printf("Cписок фруктов с буквы 'a': %s%n",
                StreamOperations2.sortbyChareAndOrderByLenght(fruits, 'a'));
        System.out.printf("\nСписко чисел: %s.\nПреобразованные из списка числа в двоичный формат: %s%n"
                .formatted(listOfPrimeNumbers,
                        StreamOperations2.getListOfPrimeNumbers(listOfPrimeNumbers)));
        System.out.printf("Cписок слов которые содержат буквы латинского алфавита: %s%n",
                StreamOperations2.getWordsWithAlphabetLetter(testyFruits, alphabet));
    }
}