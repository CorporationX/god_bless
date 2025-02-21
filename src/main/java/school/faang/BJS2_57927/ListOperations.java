package school.faang.BJS2_57927;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {
    public static Map<String, String> findPeopleWithMutualFriends(Map<String, List<String>> friendshipData) {
        List<String> allPersons = new ArrayList<>(friendshipData.keySet());
        return IntStream.range(0, allPersons.size())
                .boxed()
                .flatMap(personA -> IntStream.range(personA + 1, allPersons.size())
                        .filter(personB -> {
                            String namePersonA = allPersons.get(personA);
                            String namePersonB = allPersons.get(personB);
                            List<String> friendsOfPersonA = friendshipData.get(namePersonA);
                            List<String> friendsOfPersonB = friendshipData.get(namePersonB);
                            return !friendsOfPersonA.contains(namePersonB)
                                    && !Collections.disjoint(friendsOfPersonA, friendsOfPersonB);
                        })
                        .mapToObj(j -> Map.entry(allPersons.get(personA), allPersons.get(j)))
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Double> findAverageSalaryForEachDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return groupByDepartment.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> {
                            List<Employee> empInDepartment = entry.getValue();
                            double sum = empInDepartment.stream().mapToInt(Employee::getSalary).sum();
                            return sum / empInDepartment.size();
                        }));
    }

    public static List<Integer> findPalindromicNumbers(int start, int end) {
        List<Integer> numbers = IntStream.rangeClosed(start, end)
                .boxed()
                .toList();
        return numbers.stream()
                .map(num -> Integer.toString(num))
                .filter(num -> {
                    StringBuilder reverseNum = new StringBuilder();
                    reverseNum.append(num).reverse();
                    return reverseNum.toString().equals(num);
                })
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String str) {
        Set<String> palindromes = new HashSet<>();
        IntStream.range(0, str.length())
                .forEach(start ->
                        IntStream.range(start + 1, str.length() + 1)
                                .mapToObj(end -> str.substring(start, end))
                                .filter(string -> {
                                    StringBuilder reverseStr = new StringBuilder();
                                    reverseStr.append(string).reverse();
                                    return reverseStr.toString().equals(string);
                                })
                                .forEach(palindromes::add));
        return palindromes.stream().toList();
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        List<Integer> numbers = IntStream.rangeClosed(start, end)
                .boxed()
                .toList();
        return numbers.stream().filter(ListOperations::isPerfectNumber).toList();
    }

    private static boolean isPerfectNumber(int num) {
        List<Integer> divisors = IntStream.rangeClosed(1, num / 2)
                .filter(n -> num % n == 0)
                .boxed()
                .toList();

        int sum = divisors.stream().mapToInt(n -> n).sum();
        return sum == num;
    }
}
