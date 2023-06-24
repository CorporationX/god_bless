package faang.school.godbless.stream_api2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExampleTest {

    @Test
    void getUniqueNumberPairs(){
        List<Integer> list = List.of(0, 1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> result = Example.getUniquePairs(list, 6);
        List<List<Integer>> expected = List.of(List.of(1, 5), List.of(2, 4));

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getCapitalsOrderedTest(){
        Map<String, String> map = Map.of(
                "Germany", "Berlin",
                "France", "Paris",
                "Italy", "Rome",
                "Spain", "Madrid",
                "England", "London"
        );
        List<String> result = Example.getCapitalsOrdered(map);
        List<String> expected = List.of("Berlin", "London", "Madrid", "Paris", "Rome");

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getStringsSortedBySizeTest(){
        List<String> list = List.of("ss", "sum", "cat", "summer", "fire");
        List<String> result = Example.sortStringsBySize(list,'s');
        List<String> expected = List.of("ss", "sum", "summer");

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getAverageSalaryTest(){
        List<Employee> list = List.of(
                new Employee("name", 1.0, "sales"),
                new Employee("name", 2.0, "sales"),
                new Employee("name", 3.0, "sales"),
                new Employee("name", 4.0, "hr"),
                new Employee("name", 4.0, "hr"),
                new Employee("name", 4.0, "hr"));
        Map<String, Double> result = Example.getAverageSalary(list);
        Map<String, Double> expected = Map.of("sales", 2.0, "hr", 4.0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getStringsContainingAlphabetTest(){
        List<String> list = List.of("dsd", "лло", "23", "dd");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = Example.getStringsContainingAlphabet(list, alphabet);
        List<String> expected = List.of("dsd", "dd");

        Assertions.assertEquals(result, expected);
    }

    @Test
    void convertToBinaryTest(){
        List<Integer> list = List.of(1, 2, 3);
        List<String> result = Example.convertToBinary(list);
        List<String> expected = List.of("1", "10", "11");

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getPalindromsTest(){
        List<Integer> result = Example.getPalindroms(100, 112);
        List<Integer> expected = List.of(101, 111);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void getPerfectNumsTest(){
        int start = 1;
        int end = 10000;

        List<Integer> result = Example.getPerfectNums(start, end);
        List<Integer> expected = List.of(6, 28, 496, 8128);

        Assertions.assertEquals(result, expected);
    }

}
