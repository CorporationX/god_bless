import faang.school.godbless.streamApiTest2.Employee;
import faang.school.godbless.streamApiTest2.SecondStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SecondStreamTest {

    @Test
    void doThePairsThatSummaryATest() {
        //1
        List<Integer> list = Arrays.asList(1, 2, 1, 4, 5);
        List list1 = SecondStream.doThePairsThatSummaryA(list, 6);

        Assertions.assertEquals(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 5)),
                new ArrayList<>(Arrays.asList(2, 4))
        ), list1);
    }

    @Test
    void sortTheCountriesTest() {
        //2
        Map<String, String> stringStringMap = Map.of(
                "Russia", "Moscow",
                "Germany", "Berlin",
                "Japan", "Tokyo"
        );

        SecondStream.sortTheCountries(stringStringMap);
    }


    @Test
    void sortTheStringsTest() {
        //3
        List<String> strings = Arrays.asList(
                "alabama",
                "abama",
                "karamba",
                "dont say goodbye"
        );

        List<String> strings1 = SecondStream.sortTheStrings(strings, 'a');

        Assertions.assertEquals(Arrays.asList(
                "abama",
                "alabama"
        ), strings1);
    }

    @Test
    void searchFamiliarTest() {
        //4
        Map<String, List<String>> map = Map.of(
                "1", Arrays.asList("2", "3"),
                "2", Arrays.asList("1", "5"),
                "3", List.of("5"),
                "4", List.of("3")
        );

        List<Map.Entry<String, String>> strings = SecondStream.searchFamiliar(map);


        Assertions.assertEquals(
                Arrays.asList(
                        Map.entry("1", "4"),
                        Map.entry("2", "3")
                )
                , strings);
    }

    @Test
    void averageSalaryTest() {
        //4
        List<Employee> employees = Arrays.asList(
                new Employee("1", 100, "1"),
                new Employee("2", 200, "1"),
                new Employee("3", 1000, "IT"),
                new Employee("4", 10000, "IT")
        );

        Map<String, Double> map = SecondStream.averageSalary(employees);

        Assertions.assertEquals(Map.of(
                        "1", 150d,
                        "IT", 5500d
                )
                , map);
    }

    @Test
    void filterAndSortStringsTest() {
        //3
        List<String> strings = Arrays.asList(
                "abc",
                "a1c",
                "cabb",
                "bbcaa"
        );


        Assertions.assertEquals(Arrays.asList(
                "abc", "cabb", "bbcaa"
        ), SecondStream.filterAndSortStrings(strings, "abc"));
    }

    @Test
    void convertToBinaryTest() {
        //3
        List<Integer> integers = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );


        Assertions.assertEquals(Arrays.asList(
                "1", "10", "11", "100", "101", "110"
        ), SecondStream.convertToBinary(integers));
    }

    @Test
    void findThePalindromesTest() {
        Assertions.assertArrayEquals(new int[]{11, 22, 33, 44},
                SecondStream.findThePalindromes(10, 50));
    }

}
