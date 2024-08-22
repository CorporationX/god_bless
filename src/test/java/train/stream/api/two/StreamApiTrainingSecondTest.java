package train.stream.api.two;

import faang.school.godbless.train.stream.api.two.Employee;
import faang.school.godbless.train.stream.api.two.StreamApiTrainingSecond;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamApiTrainingSecondTest {

    @Test
    void testFindSumPairs() {
        List<List<Integer>> pairs = StreamApiTrainingSecond.findPairs(List.of(1, 9, 3, 6, 4, 5), 10);
        Assertions.assertEquals(2, pairs.size());
        Assertions.assertTrue(pairs.get(0).containsAll(List.of(1, 9)));
        Assertions.assertTrue(pairs.get(1).containsAll(List.of(6, 4)));
    }

    @Test
    void testGetCapitals() {
        Map<String, String> capitalCountryMap = Map.of(
                "Belgium", "Brussels",
                "Croatia", "Zagreb",
                "Bulgaria", "Sofia",
                "France", "Paris",
                "Russia", "Moscow");

        List<String> capitals = StreamApiTrainingSecond.getCapitals(capitalCountryMap);
        Assertions.assertEquals(5, capitals.size());
        Assertions.assertEquals("Brussels", capitals.get(0));
        Assertions.assertEquals("Sofia", capitals.get(1));
        Assertions.assertEquals("Zagreb", capitals.get(2));
        Assertions.assertEquals("Paris", capitals.get(3));
        Assertions.assertEquals("Moscow", capitals.get(4));
    }

    @Test
    void testSpecialSort() {

        String line1 = "sdfsff df asfs  fds s sfd sd dfs";
        String line2 = "sdfsd";
        String line3 = "setegdfgfhr gdfghd";

        List<String> lines = List.of(
                "afsdfsf dsfd f",
                "dgsdgdd dfg dfg  sdgf d fg f",
                line1,
                line2,
                "afsafgdgfdgd",
                line3);

        List<String> sortedLines = StreamApiTrainingSecond.specialSort(lines, 's');
        Assertions.assertEquals(3, sortedLines.size());
        Assertions.assertEquals(line2, sortedLines.get(0));
        Assertions.assertEquals(line3, sortedLines.get(1));
        Assertions.assertEquals(line1, sortedLines.get(2));
    }

    @Test
    void testFindCommonFriendsForKeys() {
        Map<String, List<String>> keyPersonFriends = Map.of(
                "Mary", List.of("Alan", "Josh", "Sam"),
                "Max", List.of("Mark", "Siu", "Adam"),
                "Kate", List.of("Tim", "Alan", "Liza", "Josh"),
                "Adam", List.of("Pavel", "Elon", "Bill"));

        Set<List<String>> pairs = StreamApiTrainingSecond.findCommonFriendsForKeys(keyPersonFriends);
        Assertions.assertEquals(1, pairs.size());
        Assertions.assertTrue(pairs.contains(List.of("Kate", "Mary")));
    }

    @Test
    void testFindCommonFriendsForAllPeople() {
        Map<String, List<String>> keyPersonFriends = Map.of(
                "Mary", List.of("Alan", "Josh", "Sam"),
                "Kate", List.of("Tim", "Alan", "Liza", "Josh"));

        Set<List<String>> pairs = StreamApiTrainingSecond.findCommonFriendsForAllPeople(keyPersonFriends);
        Assertions.assertEquals(9, pairs.size());
        Assertions.assertTrue(pairs.containsAll(Set.of(
                List.of("Josh", "Liza"),
                List.of("Liza", "Tim"),
                List.of("Kate", "Mary"),
                List.of("Alan", "Tim"),
                List.of("Alan", "Liza"),
                List.of("Josh", "Tim"),
                List.of("Alan", "Josh"),
                List.of("Josh", "Sam"),
                List.of("Alan", "Sam"))));
    }

    @Test
    void testGetAverageSalary() {
        List<Employee> employees = List.of(
                new Employee("Tom", "managers", 100000),
                new Employee("Mike", "developers", 120000),
                new Employee("John", "managers", 110000)
        );

        Map<String, Double> averageSalary = StreamApiTrainingSecond.getAverageSalary(employees);
        Assertions.assertEquals(2, averageSalary.size());
        Assertions.assertEquals(105000, averageSalary.get("managers"));
        Assertions.assertEquals(120000, averageSalary.get("developers"));
    }

    @Test
    void testFilterByAlphabet() {
        List<String> words = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> resultStrings = StreamApiTrainingSecond.filterByAlphabet(words, alphabet.toCharArray());
        Assertions.assertFalse(resultStrings.contains("123"));
        Assertions.assertTrue(resultStrings.get(0).equals("dog") || resultStrings.get(1).equals("dog"));
        Assertions.assertTrue(resultStrings.get(0).equals("cat") || resultStrings.get(1).equals("cat"));
        Assertions.assertEquals("apple", resultStrings.get(2));
        Assertions.assertEquals("banana", resultStrings.get(3));
    }

    @Test
    void testConvertToBinary() {
        List<String> convertedToBinary = StreamApiTrainingSecond.convertToBinary(List.of(1, 2, 3, 4, 5));
        Assertions.assertEquals("1", convertedToBinary.get(0));
        Assertions.assertEquals("10", convertedToBinary.get(1));
        Assertions.assertEquals("11", convertedToBinary.get(2));
        Assertions.assertEquals("100", convertedToBinary.get(3));
        Assertions.assertEquals("101", convertedToBinary.get(4));
    }

    @Test
    void testFindPalindromes() {
        List<Integer> palindromes = StreamApiTrainingSecond.findPalindromes(10, 23);
        Assertions.assertEquals(2, palindromes.size());
        Assertions.assertTrue(palindromes.containsAll(List.of(11, 22)));
    }
}
