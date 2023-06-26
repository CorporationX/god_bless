package faang.school.godbless.sprint3.streams.streamApiTraining2;

import faang.school.godbless.sprint3.streams.streamApiTraining2.classes.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Services {

    public static List<String> filterAndSortString(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, Integer> avgWageByDepartment(List<Employee> list) {
        Map<String, List<Employee>> mapEmployeeByDepartment = new HashMap<>();
        list
                .forEach(employee -> {
                    String department = employee.getDepartment();
                    if (mapEmployeeByDepartment.containsKey(department)) {
                        mapEmployeeByDepartment.put(department, new ArrayList<>());
                    }
                    mapEmployeeByDepartment.get(department).add(employee);
                });
        return null;
    }
}
