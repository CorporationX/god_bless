package faang.school.godbless.BJS2_10778;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeClass {
    public static Set<Pair<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, int number) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> !i.equals(j))
                        .filter(j -> i + j == number)
                        .map(j ->
                                {
                                    if (i > j)
                                        return new Pair<>(i, j);
                                    else
                                        return new Pair<>(j, i);
                                }
                        ))
                .collect(Collectors.toSet());

    }

    public static List<String> printCapitalsOfCountries(Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterLinesStartWithChar(List<String> lines, char character) {

        return lines.stream()
                .filter(s -> s.startsWith(Character.toString(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<Pair<String>> findUsersNotFriend(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .flatMap(i -> map.entrySet().stream()
                        .filter(j -> !i.equals(j))
                        .filter(j -> !j.getValue().contains(i.getKey()))
                        .filter(j -> i.getValue().stream()
                                .anyMatch(IFriend -> j.getValue().contains(IFriend)))
                        .map(j -> {
                            if (i.getKey().compareTo(j.getKey()) <= 0) {
                                return new Pair<>(i.getKey(), j.getKey());
                            } else {
                                return new Pair<>(j.getKey(), i.getKey());
                            }
                        }))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryOnDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, char[] alphabet) {
        Set<Integer> alphabetSet = String.valueOf(alphabet).chars().boxed().collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(alphabetSet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertIntegerToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .map(String::valueOf)
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .map(Integer::valueOf)
                .toList();
    }
}
