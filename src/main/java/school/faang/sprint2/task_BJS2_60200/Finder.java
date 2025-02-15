package school.faang.sprint2.task_BJS2_60200;

import school.faang.sprint2.task_BJS2_60200.employee.SalaryDepartmentAverager;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.palindrome.PalindromeGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.PairGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Finder {
    // /people
    public Set<Pair> findPeopleWithMutualFriends(Map<Person, Set<Person>> peopleWithFriends) {
        validMap(peopleWithFriends);
        Set<Pair> pairOfPeople = new HashSet<>();
        PairGenerator pairGenerator = new PairGenerator(peopleWithFriends);
        
        Set<Person> persons = peopleWithFriends.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        persons.forEach(friend -> {
            peopleWithFriends.forEach((person, friends) -> {
                if (person != null && person != friend && friends.contains(friend)) {
                    pairGenerator.addPerson(person);
                }
            });
            pairOfPeople.addAll(pairGenerator.generateAllPairs());
        });
        return pairOfPeople;
    }

    private <T, U> void validMap(Map<T, U> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Карта не может быть пустой");
        }
    }

    // /employee
    public Map<Department, Double> getAverageSalaryOfDepartments(Set<Employee> employees) {
        SalaryDepartmentAverager salaryDepartmentAverager = new SalaryDepartmentAverager();
        employees.forEach(salaryDepartmentAverager::addEmployee);
        return salaryDepartmentAverager.getAverageSalaryOfDepartments();
    }

    // /palindrome
    public Set<Integer> getPalindromesBetween(int start, int end) {
        Set<Integer> palindromeNumbers = new HashSet<>();
        PalindromeGenerator isntEvenPalindromeGenerator = new PalindromeGenerator();
        PalindromeGenerator evenPalindromeGenerator = new PalindromeGenerator();


        fillPalindromeNumbers(palindromeNumbers, isntEvenPalindromeGenerator, start, end);
        fillPalindromeNumbers(palindromeNumbers, evenPalindromeGenerator, start, end);

        return palindromeNumbers;
    }

    private void fillPalindromeNumbers(Set<Integer> palindromeNumbers,
                                       PalindromeGenerator palindromeGenerator, int start, int end) {
        int number = palindromeGenerator.getNextPalindrome();
        while (number < end) {
            if (number > start) {
                palindromeNumbers.add(number);
            }
            number = palindromeGenerator.getNextPalindrome();
        }
    }

}
