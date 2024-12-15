package school.faang.moduleone.sprinttwo.task_43543;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.convertDecimalsDigitsToBinary;
import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.findSortedCapitals;
import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.findSortedCapitalsWithTreeMap;
import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.findStartsWithAndSortedByLength;
import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.findUniquePairsWithCertainSum;
import static school.faang.moduleone.sprinttwo.task_43543.StreamOperations.findWordWithCertainLettersAndSortedByLength;

public class Main {
    public static void main(String[] args) {
        Set<List<Integer>> uniquePairsWithCertainSum =
                findUniquePairsWithCertainSum(List.of(1, 2, 3, 2, 4, 5, 5, 6), 7);
        uniquePairsWithCertainSum
                .forEach(System.out::println);

        Map<String, String> countriesAndCapitals = Map.of("Russia", "Moscow",
                "USA", "Washington", "Germany", "Berlin", "Greece", "Athens");
        System.out.println(findSortedCapitals(countriesAndCapitals));
        System.out.println(findSortedCapitalsWithTreeMap(countriesAndCapitals));

        List<String> source = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(findStartsWithAndSortedByLength(source, 'a'));

        List<Integer> decimalDigits = List.of(1, 2, 3, 4);
        System.out.println(convertDecimalsDigitsToBinary(decimalDigits));

        List<String> source2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(findWordWithCertainLettersAndSortedByLength(source2, "abcdefghijklmnopqrstuvwxyz"));
    }
}
