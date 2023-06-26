package faang.school.godbless.pracriceStreamAPI2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamAPI {
    public static Set<List<Integer>> setOfUniqCouplesOfNumbers(List<Integer> numbersList, Integer number) {
        return numbersList.stream()
                .filter(nl -> numbersList.contains(number - nl))
                .map(n -> Arrays.asList(n, number - n))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAlphabetically(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue).toList();
    }
    public static Map<String, Double> creatMapWithAverageSalary(List<Employee> list) { // отдел, сред зарплата
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> sortedLinesByLetters(List<String> lines, String alphabet) {
        return lines.stream()
                .filter(str -> Boolean.parseBoolean(str.replaceAll(" ", "")))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> intToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).collect(Collectors.toList());
    }

}
