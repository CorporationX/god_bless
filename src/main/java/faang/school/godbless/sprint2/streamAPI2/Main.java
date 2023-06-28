package faang.school.godbless.sprint2.streamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public Set<List<Integer>> uniqueNumbers(List<Integer> list, Integer number) {
        return list.stream().filter(x -> list.contains(number - x))
                .map(e -> Arrays.asList(e, number - e))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public List<String> sortCountres(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue).toList();
    }


    public List<String> sortedStrings(List<String> list, char chars) {
        return list.stream()
                .filter(string -> string.toLowerCase().startsWith(String.valueOf(chars).toLowerCase()))
                .sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    public Map<String, Double> averageSalary(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }


    public List<String> sortStrings(List<String> list, String alphabet) {
        return list.stream()
                .filter(string -> string.replaceAll(" ", "")
                        .toLowerCase().matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }


    public List<String> numToBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }
}
