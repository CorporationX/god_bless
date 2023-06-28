import faang.school.godbless.pracriceStreamAPI2.Employee;
import faang.school.godbless.pracriceStreamAPI2.StreamAPI;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StreamAPITest2 {
    @Test
    public void setOfUniqCouplesOfNumbersTest() {
        List<Integer> integerList = List.of(1, 3, 4, 6, 9);
        Set<List<Integer>> test = StreamAPI.setOfUniqCouplesOfNumbers(integerList, 5);
        List<Integer> expectedListTest1 = List.of(1, 4);
        List<Integer> expectedListTest2 = List.of(1, 3);
        assertTrue(test.contains(expectedListTest1));
        assertFalse(test.contains(expectedListTest2));
        assertEquals(1, test.size());
    }

    @Test
    public void sortCountriesAlphabeticallyTest() {
        Map<String, String> countriesAndCapitals = Map.of("Spain", "Madrid", "Portugal", "Lisbon");
        List<String> test = StreamAPI.sortCountriesAlphabetically(countriesAndCapitals);
        List<String> expected = List.of("Lisbon", "Madrid");
        assertEquals(expected, test);
    }

    @Test
    public void sortLinesThatStartsWithLetterTest() {
        List<String> linesTest = List.of("Africa", "Android", "Airplane"); //6,7,8
        List<String> testMethod = StreamAPI.sortLinesThatStartsWithLetter(List.of("Airplane", "Android", "Africa"), 'A');
        assertEquals(linesTest, testMethod);
    }

    @Test
    public void creatMapWithAverageSalaryTest() {
        List<Employee> listOfEmployeesTest = List.of(
                new Employee("Boris", 10, "Marketing"),
                new Employee("Misha", 20, "IT"),
                new Employee("Oleg", 30, "Business")
        );
        Map<String, Double> mapTest = StreamAPI.creatMapWithAverageSalary(listOfEmployeesTest);
        assertEquals(10, mapTest.get("Marketing"));
        assertEquals(30, mapTest.get("Business"));
        assertEquals(3, mapTest.size());
    }

    @Test
    public void sortedLinesByLettersTest() {
        String alphabet = "abcde";
        List<String> listOfWords = List.of("ab", "abc", "abd", "a");
        List<String> testMethod = StreamAPI.sortedLinesByLetters(listOfWords, alphabet);
        assertEquals(List.of("a", "ab", "abc", "abd"), testMethod);
    }

    @Test
    public void intToStringTest() {
        List<String> listOfStringsTest = StreamAPI.intToString(List.of(2, 4, 7, 9));
        List<String> expected = List.of("10", "100", "111", "1001");
        assertEquals(expected, listOfStringsTest);
    }
    @Test
    public void findPalindromesTest() {
        List<Integer> expectedList = List.of(55, 66, 77, 88, 99, 101, 111);
        List<Integer> testMethod = StreamAPI.findPalindromes(55, 111);
        assertEquals(expectedList, testMethod);
    }
}
