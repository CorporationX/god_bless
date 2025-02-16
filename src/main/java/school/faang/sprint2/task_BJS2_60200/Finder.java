package school.faang.sprint2.task_BJS2_60200;

import school.faang.sprint2.task_BJS2_60200.employee.SalaryDepartmentAverager;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.palindrome.number.PalindromeGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.PairGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.HashSet;
import java.util.List;
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

    public Set<String> getPalindromesSubstring(String string) {
        Set<String> palindromeSubstring = new HashSet<>();
        int stringLength = string.length();
        int stringStart = 0;
        int rootPointer = 0;
        int leftPointer;
        int rightPinter;

        while (rootPointer < stringLength) {
            leftPointer = rootPointer;
            rightPinter = rootPointer;

            while (leftPointer >= stringStart && rightPinter < stringLength) {
                if (string.charAt(leftPointer) == string.charAt(rightPinter)) {
                    String substring = string.substring(leftPointer, rightPinter + 1);
                    palindromeSubstring.add(substring);
                }
                leftPointer--;
                rightPinter++;
            }
            rootPointer++;
        }
        return palindromeSubstring;
    }

    public Set<Integer> getPerfectNumbersBetween(int start, int end) {
        List<Integer> primeNumbers = List.of(2, 3, 5, 7);
        Set<Integer> perfectNumbers = new HashSet<>();

        primeNumbers.forEach(primeNumber -> {
            int perfectNumber = (int) Math.pow(2, (primeNumber - 1)) * ((int) Math.pow(2, primeNumber) - 1);
            if (start <= perfectNumber && perfectNumber < end) {
                perfectNumbers.add(perfectNumber);
            }
        });

        return perfectNumbers;
    }
}
