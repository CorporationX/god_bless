package faang.school.godbless.Sprint3.task2_API;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiMethodsTest {
    StreamApiMethods streamApiMethods = new StreamApiMethods();

    @Test
    void testUniqueCouples() {
        List<Integer> numbers = Arrays.asList(6, 4, 2, 3, 4, 5, 6, 2);
        Integer sum = 8;

        Set<List<Integer>> expected = Set.of(Arrays.asList(4, 4), Arrays.asList(3, 5), Arrays.asList(2, 6));
        Set<List<Integer>> actual = streamApiMethods.uniqueCouples(numbers, sum);

        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testGetCapitals() {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("Germany", "Berlin");
        countriesAndCapitals.put("Ukraine", "Kiev");
        countriesAndCapitals.put("Brazil", "Rio de Janeiro");

        List<String> expected = List.of("Rio de Janeiro", "Berlin", "Moscow", "Kiev");
        List<String> actual = streamApiMethods.getCapitals(countriesAndCapitals);

        assertEquals(4, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testStringFilterStartingChar() {
        List<String> strings = List.of("McGregor", "Nurmagomedov", "Masvidal", "Adesanya");
        char firstChar = 'M';

        List<String> expected = List.of("McGregor", "Masvidal");
        List<String> actual = streamApiMethods.stringFilterStartingChar(strings, firstChar);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testSearchPairsUnfriendsWithMutualFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Tolstoy", Arrays.asList("Dostoevsky", "Chekhov"));
        friends.put("Dostoevsky", Arrays.asList("Tolstoy", "Gogol"));
        friends.put("Chekhov", Arrays.asList("Tolstoy", "Gogol"));
        friends.put("Gogol", Arrays.asList("Dostoevsky", "Chekhov"));

        List<List<String>> expected = List.of(Arrays.asList("Gogol", "Tolstoy"), Arrays.asList("Chekhov", "Dostoevsky"));
        List<List<String>> actual = streamApiMethods.searchPairsUnfriendsWithMutualFriends(friends);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testGetAverageSalaries() {
        List<Employee> employees = Arrays.asList(
                new Employee("Conor McGregor", "UFC", 1000000),
                new Employee("Jon Jones", "UFC", 750000),
                new Employee("Khabib Nurmagomedov", "UFC", 800000),
                new Employee("Israel Adesanya", "UFC", 500000),
                new Employee("Ryan Bader", "Bellator", 400000),
                new Employee("Gegard Mousasi", "Bellator", 350000)
        );

        Map<String, Double> expected = Map.of("UFC", 762500.0, "Bellator", 375000.0);
        Map<String, Double> actual = streamApiMethods.getAverageSalaries(employees);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testStringFilterContainsAlphabet() {
        List<String> strings = Arrays.asList("Jon", "Rasul", "Mike", "Ra", "Chuck", "Raul");
        String alphabet = "Rasul";

        List<String> expected = Arrays.asList("Ra", "Raul", "Rasul");
        List<String> actual = streamApiMethods.stringFilterContainsAlphabet(strings, alphabet);

        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testConvertNumbersToBinaryStrings() {
        List<Integer> numbers = Arrays.asList(22, 8, 1987);

        List<String> expected = Arrays.asList("10110", "1000", "11111000011");
        List<String> actual = streamApiMethods.convertNumbersToBinaryStrings(numbers);

        assertEquals(3, expected.size());
        assertEquals(expected, actual);
    }

    @Test
    void testFindPalindromesInRange() {
        int startRange = 900;
        int endRange = 1100;

        List<Integer> expected =
                List.of(909, 919, 929, 939, 949, 959, 969, 979, 989, 999, 1001);
        List<Integer> actual = streamApiMethods.findPalindromesInRange(startRange, endRange);

        assertEquals(11, actual.size());
        assertEquals(expected, actual);
    }
}