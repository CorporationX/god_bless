package bjs257883;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculations {
    public Set<List<String>> getFriendlyPeople(Map<String, List<String>> people) {
        Set<List<String>> set = new HashSet<>();
        people.keySet()
                .forEach(name
                        -> set
                        .add(new ArrayList<>(getSymmetricDifference(
                                new HashSet<>(people.get(name)), people.keySet()))));
        return set;
    }

    private <T> Set<T> getSymmetricDifference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        for (T element : b) {
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }

    public Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
    }

    public List<Integer> getNumbersPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(number -> new StringBuilder(number.toString()).reverse().toString().equals(number.toString()))
                .toList();
    }

    public List<String> getSubstringsPalindromes(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.range(i, input.length())
                        .filter(j -> new StringBuilder(input.substring(i, j + 1)).reverse().toString()
                                .equals(input.substring(i, j + 1)))
                        .mapToObj(j -> input.substring(i, j + 1)))
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }
}
