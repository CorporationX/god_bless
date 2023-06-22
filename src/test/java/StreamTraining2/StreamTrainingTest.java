package StreamTraining2;

import faang.school.godbless.StreamTraining2.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.StreamTraining2.StreamTraining.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamTrainingTest {
    @Test
    void uniquePairsTest() {
        List<Integer> list = List.of(2, 5, 7, 1, 3, 9, 6, 8, 4, 0, 2, 4, 0, 3, 1);

        Map<Integer, Integer> pairs = uniquePairs(list, 4);

        assertEquals(Map.of(1, 3, 2, 2, 4, 0), pairs);
    }

    @Test
    void capitalsTest() {
        Map<String, String> countriesAndCapitals = Map.of("Angola", "Luanda",
                "Slovakia", "Bratislava",
                "Norway", "Oslo",
                "Philippines", "Manila",
                "Malawi", "Lilongwe",
                "Palau", "Athens",
                "Greece", "Male",
                "Vanuatu", "Port Vila");

        List<String> result = capitals(countriesAndCapitals);

        assertEquals(List.of("Luanda", "Male", "Lilongwe", "Oslo", "Athens", "Manila", "Bratislava", "Port Vila"), result);
    }

    @Test
    void sortedStringsTest() {
        List<String> list = List.of("Aragorn", "Frodo", "Sauron", "Gandalf", " Gimli", "Legolas", "Gollum", "Galadriel");
        char ch = 'g';

        List<String> result = sortedStrings(list, ch);

        assertEquals(List.of("Gollum", "Gandalf", "Galadriel"), result);
    }

    @Test
    void friendsOfFriendsTest() {
        Map<String, List<String>> map = Map.of("Aragorn", List.of("Frodo", "Gimli", "Legolas"),
                "Celeborn", List.of("Legolas", "Elrond", "Aragorn"),
                "Galadriel", List.of("Legolas", "Arwen"),
                "Sauron", List.of("Saruman", "Gandlaf"));


        Map<String, String> result = friendsOfFriends(map);

        System.out.println(result);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void averageSalaryTest() {
        Employee employee = new Employee("William", "HR", 1500);
        Employee employee1 = new Employee("Christian", "Development", 500);
        Employee employee2 = new Employee("Jon", "HR", 1500);
        Employee employee3 = new Employee("Jordan", "Development", 200);
        Employee employee4 = new Employee("Sofi", "HR", 3000);
        List<Employee> employees = List.of(employee, employee2, employee1, employee3, employee4);

        Map<String, Double> result = averageSalary(employees);

        assertEquals(350.0, result.get("Development"));
        assertEquals(2000.0, result.get("HR"));
    }

    @Test
    void alphabetContainsTest() {
        String str = "abc";
        String str1 = "cba a b b";
        String str2 = "aaa";
        String str3 = "";
        String str4 = "WaNg";
        List<String> list = List.of(str, str1, str2, str3, str4);
        String alphabet = "abc";

        List<String> result = alphabetContains(list, alphabet);

        assertEquals(List.of("abc", "aaa", "cba a b b"), result);
    }

    @Test
    void numToBinaryTest() {
        List<Integer> list = List.of(2, 5, 7, 1, 3, 9, 6, 8, 4, 0, 2, 4, 0, 3, 1);

        List<String> result = numToBinary(list);

        System.out.println(result);
        assertEquals(List.of("10", "101", "111", "1", "11", "1001", "110", "1000", "100", "0", "10", "100", "0", "11", "1"), result);
    }

    @Test
    void numPalindromesTest() {
        List<Integer> result = numPalindromes(0, 100);

        assertEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99), result);
    }

    @Test
    void perfectNumbersTest() {
        List<Integer> result = perfectNumbers(0, 100);

        assertEquals(List.of(0, 6, 28), result);
    }
}
