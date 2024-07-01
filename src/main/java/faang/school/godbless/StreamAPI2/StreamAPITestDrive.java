package faang.school.godbless.StreamAPI2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPITestDrive {
    //Task 1
    public static List<List<Integer>> integersBySum(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(integer -> numbers.contains(sum - integer))
                .filter(integer -> numbers.indexOf(integer) != numbers.lastIndexOf(sum - integer))
                .map(integer -> List.of(Math.min(integer, sum - integer), Math.max(integer, sum - integer)))
                .distinct()
                .toList();
    }

    //Task 2
    public static void countriesAndCapitals(Map<String, String> countriesAndCapitals) {
        countriesAndCapitals.keySet().stream()
                .sorted()
                .map(countriesAndCapitals::get)
                .forEach(System.out::println);
    }

    //Task 3
    public static List<String> stringFilter(List<String> strings, char word) {
        return strings.stream()
                .filter(a -> !a.isEmpty() && a.charAt(0) == word)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors
                        .toList());
    }

    //Task 4
    //public static List<List<String>> friends(Map<String, List<String>> peopleAndTheirFriends) {
    //    return peopleAndTheirFriends.keySet().stream()
    //            .filter
    //}

    //Task 5
    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::division,
                        Collectors.averagingInt(Employee::salary)));
    }


    //Task 6
    public static List<String> sortByAlphabet(List<String> strings, List<Character> alphabet) {
        return strings.stream()
                .filter(str -> !str.isEmpty())
                .filter(str -> str.chars()
                        .mapToObj(a -> (char) a)
                        .allMatch(alphabet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Task 7
    public static List<String> numbersToStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //Task 8
    //public static List<Integer> numericPalindromes(int start, int end) {
    //    return
    //}
}