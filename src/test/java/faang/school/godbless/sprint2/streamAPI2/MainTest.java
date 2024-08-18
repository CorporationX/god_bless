package faang.school.godbless.sprint2.streamAPI2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findUniquePairs() {
        List<Integer> inputList = List.of(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        Set<List<Integer>> result = Main.findUniquePairs(inputList, targetSum);
        Set<List<Integer>> expected = Set.of(List.of(1, 9), List.of(4, 6));
        assertEquals(expected, result);
    }

    @Test
    void capitalsBySortedCounties() {
        Map<String, String> countriesWithCapitals = new HashMap<>();
        countriesWithCapitals.put("Россия", "Москва");
        countriesWithCapitals.put("Беларусь", "Минск");
        countriesWithCapitals.put("Китай", "Пекин");
        countriesWithCapitals.put("Великобритания", "Лондон");
        countriesWithCapitals.put("Франция", "Париж");
        List<String> result = Main.capitalsBySortedCounties(countriesWithCapitals);
        List<String> expected = List.of("Минск", "Лондон", "Пекин", "Москва", "Париж");
        assertEquals(expected, result);
    }

    @Test
    void sortedStringsThatStartWithChar() {
        List<String> inputList = List.of("абв", "ананас", "айфон", "морс", "яблоко", "а", "фрукт");
        char ch = 'а';
        List<String> result = Main.sortedStringsThatStartWithChar(inputList, ch);
        List<String> expected = List.of("а", "абв", "айфон", "ананас");
        assertEquals(expected, result);
    }

    @Test
    void findNotFriendsWithMutualFriends() {
        Map<String, List<String>> peoples = new HashMap<>();
        peoples.put("Алексей", List.of("Витя", "Вадим"));
        peoples.put("Витя", List.of("Алексей"));
        peoples.put("Маша", List.of("Вадим"));
        peoples.put("Вадим", List.of("Маша", "Алексей"));
        Set<Set<String>> result = Main.findNotFriendsWithMutualFriends(peoples);
        Set<Set<String>> expected = Set.of(Set.of("Алексей", "Маша"), Set.of("Вадим", "Витя"));
        assertEquals(expected, result);
    }

    @Test
    void filterListByAlphabetAndSorted() {
        List<String> inputList = List.of("apple", "banana", "123", "dog", "cat", "айфон", "ананас");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = Main.filterListByAlphabetAndSorted(inputList, alphabet);
        List<String> expected = List.of("dog", "cat", "apple", "banana");
        assertEquals(expected, result);
    }

    @Test
    void toBinary() {
        List<Integer> inputList = List.of(1, 2, 3, 5, 10, 256);
        List<String> result = Main.toBinary(inputList);
        List<String> expected = List.of("1", "10", "11", "101", "1010", "100000000");
        assertEquals(expected, result);
    }

    @Test
    void averageSalaryForEachDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Виктор", 100, "Отдел 1"));
        employees.add(new Employee("Алексей", 200, "Отдел 1"));
        employees.add(new Employee("Мария", 150, "Отдел 1"));
        employees.add(new Employee("Мария", 300, "Отдел 2"));
        employees.add(new Employee("Петр", 200, "Отдел 2"));
        employees.add(new Employee("Кирилл", 250, "Отдел 2"));
        Map<String, Double> result = Main.averageSalaryForEachDepartment(employees);
        Map<String, Double> expected = Map.of("Отдел 1", 150.0, "Отдел 2", 250.0);
        assertEquals(expected, result);
    }

    @Test
    void palindromesNumbersFrom121To121() {
        int begin = 121;
        int end = 121;
        List<Integer> expected = List.of(121);
        List<Integer> result = Main.palindromesNumbers(begin, end);
        assertEquals(expected, result);
    }

    @Test
    void palindromesNumbersFrom0To9() {
        int begin = 0;
        int end = 9;
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = Main.palindromesNumbers(begin, end);
        assertEquals(expected, result);
    }

    @Test
    void palindromesNumbersFrom10To150() {
        int begin = 10;
        int end = 150;
        List<Integer> expected = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141);
        List<Integer> result = Main.palindromesNumbers(begin, end);
        assertEquals(expected, result);
    }

    @Test
    void findAllSubstringsThatPalindromes() {
        String string = "ababac";
        List<String> expected = List.of("a", "aba", "ababa", "b", "bab", "c");
        List<String> result = Main.findAllSubstringsThatPalindromes(string);
        assertEquals(expected, result);
    }

    @Test
    void perfectNumbersFrom1To10() {
        int begin = 1;
        int end = 10;
        List<Integer> expected = List.of(6);
        List<Integer> result = Main.perfectNumbers(begin, end);
        assertEquals(expected, result);
    }

    @Test
    void perfectNumbersFrom1To10000() {
        int begin = 1;
        int end = 10000;
        List<Integer> expected = List.of(6, 28, 496, 8128);
        List<Integer> result = Main.perfectNumbers(begin, end);
        assertEquals(expected, result);
    }
}