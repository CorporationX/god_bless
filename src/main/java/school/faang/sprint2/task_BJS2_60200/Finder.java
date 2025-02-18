package school.faang.sprint2.task_BJS2_60200;

import school.faang.sprint2.task_BJS2_60200.employee.SalaryDepartmentAverager;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.PairGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Finder {
    // /people
    public Set<Pair> findPeopleWithMutualFriends(Map<Person, Set<Person>> peopleWithFriends) {
        validateMap(peopleWithFriends);
        PairGenerator pairGenerator = new PairGenerator(peopleWithFriends);
        peopleWithFriends.values().forEach(pairGenerator::generateAllPairs);
        return pairGenerator.getPairOfPeople();
    }

    private <T, U> void validateMap(Map<T, U> map) {
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
        return IntStream.range(start, end)
                .filter(this::isPalindrome)
                .boxed()
                .collect(Collectors.toSet());
    }

    private boolean isPalindrome(int number) {
        String val = String.valueOf(number);
        String reversed = new StringBuilder(val).reverse().toString();
        return val.equals(reversed);
    }

    public Set<String> getPalindromesSubstring(String string) {
        Set<String> palindromeSubstring = new HashSet<>();

        IntStream.range(0, string.length())
                .forEach(pointer -> {
                    int leftPointer = pointer + 1;
                    int rightPinter = pointer - 1;

                    while (--leftPointer >= 0 && ++rightPinter < string.length()) {
                        if (string.charAt(leftPointer) == string.charAt(rightPinter)) {
                            String substring = string.substring(leftPointer, rightPinter + 1);
                            palindromeSubstring.add(substring);
                        } else {
                            break;
                        }
                    }
                });

        return palindromeSubstring;
    }

    public Set<Integer> getPerfectNumbersBetween(int start, int end) {
        return IntStream.range(start, end)
                .filter(this::isPerfect)
                .boxed()
                .collect(Collectors.toSet());
    }

    private boolean isPerfect(int num) {
        if (num < 1) {
            return false;
        }
        return IntStream.range(1, num)
                .filter(i -> num % i == 0)
                .sum() == num;
    }
}
