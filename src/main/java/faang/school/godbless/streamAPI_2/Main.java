package faang.school.godbless.streamAPI_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    private static final List<Integer> NUMBERS = List.of(1, 9, 3, 6, 4, 5);
    private static final Map<String, String> COUNTRIES = new HashMap<>();
    private static final List<String> STRINGS = List.of("Russia", "Beijing",
            "Berlin", "Roma", "Moscow", "Madrid");
    private static final Map<String, List<String>> FRIENDS = new HashMap<>();


    public static void /*List<List<Integer>>*/ getPairs(List<Integer> inputList, int target) {
        System.out.println("Input List: " + inputList);
        System.out.println("Target Sum: " + target);
        List<Integer> pairs = new ArrayList<>();

//        pairs.stream()
//                .flatMapToInt(integer -> {
//                    integer
//                })
        for (int i = 0; i < inputList.size() - 1; i++) {
            pairs = Stream.of(inputList.get(i) + inputList.get(i + 1))
                    .filter(integer -> integer == 10)
                    .toList();
        }
        System.out.println(pairs);
//        return pairs;
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> inputMap) {
        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList()
                .stream()
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getStringsSortedByLength(List<String> inputStrings, char inputChar) {
        String input = String.valueOf(inputChar);
//        System.out.println("input = " + inputChar);
        return inputStrings.stream()
                .filter(string -> string.startsWith(input))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }


    public static void main(String[] args) {
//        getPairs(NUMBERS, 10);
//
//        COUNTRIES.put("Russia", "Moscow");
//        COUNTRIES.put("USA", "New York");
//        COUNTRIES.put("Germany", "Berlin");
//        COUNTRIES.put("Spain", "Madrid");
//        COUNTRIES.put("Italy", "Roma");
//        COUNTRIES.put("China", "Beijing");
//
//        System.out.println(getCapitalsSortedByCountry(COUNTRIES));
//
//        System.out.println(getStringsSortedByLength(STRINGS, 'R'));
//
//        FRIENDS.put("Igor", List.of("Sergey", "Nikolay", "Dmitry"));
//        FRIENDS.put("Sergey", List.of("Igor", "Nikolay", "Vasily"));
//        FRIENDS.put("Nikolay", List.of("Igor", "Sergey", "Vasily"));
//        FRIENDS.put("Vasily", List.of("Sergey", "Dmitry", "Nikolay"));


        System.out.println("Point 5.");

        List<Employee> employees = new ArrayList<>();//список работников
        Set<String> keys = new HashSet<>();//список ключей

        Map<String, Double> avgSalaries = new HashMap<>();//итоговая мапа

        Employee igor = new Employee("Igor", 100, "Development");
        Employee maxim = new Employee("Maxim", 200, "Development");

        //получаем список объектов Employee
        employees.add(igor);
        employees.add(maxim);
        employees.add(new Employee("Sergy", 300, "Engineering"));
        employees.add(new Employee("Volodimir", 150, "Engineering"));
        employees.add(new Employee("Vlad", 250, "Production"));
        employees.add(new Employee("Oleg", 350, "Production"));

        //получаем список ключей
        for (Employee employee : employees) {
            keys.add(employee.department());
        }

        for (String key : keys) {
            //вычисляем кол-во работников в каждом отделе
            long amountEmployeesInDepartment = employees.stream()
                    .filter(dep -> dep.department().equals(key))
                    .count();
            //вычисляем среднюю зарплату в каждом отделе
            double avgSalary = (double) employees.stream()
                    .filter(dep -> dep.department().equals(key))
                    .map(Employee::salary)
                    .reduce(0, Integer::sum) / amountEmployeesInDepartment;
            avgSalaries.put(key, avgSalary);
        }

        System.out.println("avgSalaries = " + avgSalaries);
    }
}
