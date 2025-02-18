package school.faang.sprint2.task_BJS2_60200;

import org.junit.jupiter.api.Test;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    private final Finder finder = new Finder();

    @Test
    public void findPeopleWithMutualFriends() {
        Map<Person, Set<Person>> peopleWithFriends = new HashMap<>();
        Set<Pair> excepted = new HashSet<>();
        fillPeopleData(peopleWithFriends, excepted);

        assertEquals(excepted, finder.findPeopleWithMutualFriends(peopleWithFriends));
    }

    private void fillPeopleData(Map<Person, Set<Person>> peopleWithFriends, Set<Pair> excepted) {
        Person alice =  new Person("Alice");
        Person bob = new Person("Bob");
        Person charlie = new Person("Charlie");
        Person david = new Person("David");

        peopleWithFriends.put(alice, Set.of(bob, charlie));
        peopleWithFriends.put(bob, Set.of(alice, david));
        peopleWithFriends.put(charlie, Set.of(alice, david));
        peopleWithFriends.put(david, Set.of(bob, charlie));

        excepted.add(new Pair(alice, david));
        excepted.add(new Pair(bob, charlie));
    }

    @Test
    public void getAverageSalaryOfDepartments() {
        Set<Employee> employees = Set.of(
                new Employee("Vasya", 100_000, Department.DESIGN),
                new Employee("Petya", 200_000, Department.DESIGN),
                new Employee("Kolya", 50_000, Department.MARKETING)
        );
        Map<Department, Double> excepted = Map.of(
                Department.DESIGN, 150_000.00,
                Department.MARKETING, 50_000.00
        );

        assertEquals(excepted, finder.getAverageSalaryOfDepartments(employees));
    }

    @Test
    public void getPalindromesBetween() {
        int start = 100;
        int end = 200;
        Set<Integer> excepted = Set.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        assertEquals(excepted, finder.getPalindromesBetween(start, end));
    }

    @Test
    public void getPalindromesSubstring() {
        String test = "abac";
        Set<String> excepted = Set.of("a", "aba", "b", "c");
        assertEquals(excepted, finder.getPalindromesSubstring(test));
    }

    @Test
    public void getPerfectNumbersBetween() {
        int start = 1;
        int end = 1000;
        Set<Integer> excepted = Set.of(6, 28, 496);

        assertEquals(excepted, finder.getPerfectNumbersBetween(start, end));
    }
}