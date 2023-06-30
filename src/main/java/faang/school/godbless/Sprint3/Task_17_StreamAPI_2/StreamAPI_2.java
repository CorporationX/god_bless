package faang.school.godbless.Sprint3.Task_17_StreamAPI_2;


import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI_2 {

    public static List<List<Integer>> findUniquePairs (List<Integer> numbers, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        numbers.stream()
                .distinct()
                .filter(number -> numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .forEach(pairs::add);

        return pairs;
    }

    public static List<String> showCapitals (Map<String, String> countries) {

        return  countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

    }

    public static List<String> filterAndSortStrings (List<String> strings, char letter) {

        return strings.stream()
                .filter(string -> string.charAt(0) == letter)
                .sorted((string1, string2) -> string1.length() - string2.length())
                .toList();
    }

    public static Map<String, Double> calculateAverageSalary (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
