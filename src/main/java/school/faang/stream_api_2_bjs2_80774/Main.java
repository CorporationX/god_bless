package school.faang.stream_api_2_bjs2_80774;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.stream_api_2_bjs2_80774.ListOperations.convertingNumbers;
import static school.faang.stream_api_2_bjs2_80774.ListOperations.filteringByAlphabet;
import static school.faang.stream_api_2_bjs2_80774.ListOperations.findUniqPairs;
import static school.faang.stream_api_2_bjs2_80774.ListOperations.sortCountries;
import static school.faang.stream_api_2_bjs2_80774.ListOperations.sortFruits;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        int target = 8;
        System.out.printf("Пары для суммы %d: %s%n", target, findUniqPairs(numbers, target));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.printf("%nОтсортированные столицы: %s%n", sortCountries(countries));

        List<String> fruits = List.of("Apple", "Banana", "Apricot", "Cherry");
        char startChar = 'A';
        System.out.printf("%nФрукты на '%c': %s%n", startChar, sortFruits(startChar, fruits));

        List<Integer> nums = List.of(5, 10, 15);
        System.out.printf("%nДвоичные представления: %s%n", convertingNumbers(nums));

        List<String> words = List.of("java", "python", "c++", "scala");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.printf("%nСлова из латиницы: %s%n", filteringByAlphabet(words, alphabet));
    }
}
