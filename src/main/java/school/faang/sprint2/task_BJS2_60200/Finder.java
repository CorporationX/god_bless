package school.faang.sprint2.task_BJS2_60200;

import school.faang.sprint2.task_BJS2_60200.employee.SalaryDepartmentAverager;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.palindrome.PalindromeGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.PairGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Finder {
    // /people
    public Set<Pair> findPeopleWithMutualFriends(Map<Person, Set<Person>> peopleWithFriends) {
        validMap(peopleWithFriends);
        PairGenerator pairGenerator = new PairGenerator(peopleWithFriends);
        peopleWithFriends.values().forEach(pairGenerator::generateAllPairs);
        return pairGenerator.getPairOfPeople();
    }

    private <T, U> void validMap(Map<T, U> map) {
        if (map == null) {
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
        PalindromeGenerator palindromeGenerator = new PalindromeGenerator();
        int number = palindromeGenerator.getNextPalindrome();

        while (number < end) {
            if (number > start) {
                palindromeNumbers.add(number);
            }
            number = palindromeGenerator.getNextPalindrome();
        }
        return palindromeNumbers;
    }
}
