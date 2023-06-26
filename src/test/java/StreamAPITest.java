import faang.school.godbless.pracriceStreamAPI2.Employee;
import faang.school.godbless.pracriceStreamAPI2.StreamAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StreamAPITest {
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
    public void intToStringTest() {
        List<String> listOfStringsTest = StreamAPI.intToString(List.of(2, 4, 7, 9));
        List<String> expected = List.of("10", "100", "111", "1001");
        assertEquals(expected, listOfStringsTest);
    }
}
