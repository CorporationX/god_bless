package faang.school.godbless.streamApiTwo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTwoTest {


    @Test
    void testGetUniqueCoupleWhereSumEqualsGiven() {
        List<Integer> numbers = Arrays.asList(4, 2, 3, 4, 6, 2);
        int sum = 6;

        Set<List<Integer>> expected = Set.of(Arrays.asList(2, 4), Arrays.asList(3, 3));
        Set<List<Integer>> actual = StreamApiTwo.getUniqueCoupleWhereSumEqualsGiven(numbers,sum);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testGetCapitals() {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Belarus", "Minsk");
        countriesAndCapitals.put("Poland", "Warsaw");
        countriesAndCapitals.put("Ukraine", "Kiev");


        List<String> expected = List.of( "Minsk", "Warsaw", "Kiev");
        List<String> actual = StreamApiTwo.getCapitals(countriesAndCapitals);

        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testFilterStringsByCharAndOrder() {
        List<String> strings = List.of("McGregor", "Nurmagomedov", "Masvidal", "Adesanya");
        char firstChar = 'M';

        List<String> expected = List.of("McGregor", "Masvidal");
        List<String> actual = StreamApiTwo.filterStringsByCharAndOrder(strings, firstChar);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }



    @Test
    void testGetAverageSalaryForEveryDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000, "Engineering"),
                new Employee("Jane", 6000, "Engineering"),
                new Employee("Mike", 4000, "Sales"),
                new Employee("Emily", 4500, "Sales"),
                new Employee("David", 5500, "HR"),
                new Employee("Sarah", 5000, "HR")
        );

        Map<String, Double> expected = new HashMap<>();
        expected.put("Engineering", 5500.0);
        expected.put("Sales", 4250.0);
        expected.put("HR", 5250.0);

        Map<String, Double> result = StreamApiTwo.getAverageSalaryForEveryDepartment(employees);

        assertEquals(expected, result);
    }


    @Test
    void testConvertToBinary() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        List<String> expected = Arrays.asList("10", "100", "110", "1000", "1010");
        List<String> result = StreamApiTwo.convertToBinary(numbers);

        assertEquals(expected, result);
    }

    @Test
    void testFindPalindromeNumbers() {
        int start = 1;
        int end = 100;

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99);
        List<Integer> result = StreamApiTwo.findPalindromeNumbers(start, end);

        assertEquals(expected, result);
    }
}