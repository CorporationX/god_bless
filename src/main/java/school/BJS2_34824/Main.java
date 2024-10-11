package school.BJS2_34824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> mapOfFriends = new HashMap<>();
        mapOfFriends.put("Alice", Arrays.asList("Bob", "Charlie"));
        mapOfFriends.put("Bob", Arrays.asList("Alice", "David"));
        mapOfFriends.put("Charlie", Arrays.asList("Alice", "David"));
        mapOfFriends.put("David", Arrays.asList("Bob", "Charlie"));
        mapOfFriends.put("Roma", Arrays.asList("Charlie", "Bob"));

        Employee employee1 = new Employee("Рома", 3000, "Sber");
        Employee employee2 = new Employee("Вика", 5000, "Sber");
        Employee employee3 = new Employee("Петя", 6000, "Sber");
        Employee employee4 = new Employee("Вася", 3800, "Tinkoff");
        Employee employee5 = new Employee("Гриша", 5400, "Tinkoff");

        List<Employee> listOfEmployess = new ArrayList<>();
        listOfEmployess.add(employee1);
        listOfEmployess.add(employee2);
        listOfEmployess.add(employee3);
        listOfEmployess.add(employee4);
        listOfEmployess.add(employee5);


        System.out.println(peopleWithMutualFriends(mapOfFriends));
        for (Map.Entry<String, Double> s : averageSalaryForEachDepartment(listOfEmployess).entrySet()) {
            System.out.println(s.getKey());
            System.out.println(s.getValue());
        }
        System.out.println(numberPalindromes(100, 200));
        System.out.println(substringPalindromes("abac"));
        System.out.println(perfectNumbers(1, 1000));

    }

    public static Set<List<String>> peopleWithMutualFriends(Map<String, List<String>> mapPeopleWithFriends) {
        Map<String, List<String>> sortedMap = mapPeopleWithFriends.entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().stream().sorted()
                        .collect(Collectors.toList())));
        return sortedMap.values().stream().map(strings -> sortedMap.entrySet().stream().
                filter(y -> y.getValue().equals(strings)).
                map(Map.Entry::getKey).collect(Collectors.toList())
        ).peek(Collections::sort).collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryForEachDepartment(List<Employee> employees) {
        Map<String, List<Employee>> mapOfEmployee = employees.stream().collect(Collectors.groupingBy(x -> x.getDepartment()));
        return mapOfEmployee.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), x -> {
            int countOfEmployee = x.getValue().size();
            int sumOfSalary = x.getValue().stream().map(y -> y.getSalary()).reduce(0, (sum, y) -> sum + y);
            return (double) Math.round(sumOfSalary / countOfEmployee);
        }));
    }

    public static List<Integer> numberPalindromes(int start, int end) {
        List<Integer> listOfNumber = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            listOfNumber.add(i);
        }
        return listOfNumber.stream().filter(x -> {
            int reversed = 0;
            int k = x;
            while (k != 0) {
                reversed = reversed * 10 + k % 10;
                k /= 10;
            }
            return x == reversed;
        }).collect(Collectors.toList());
    }

    public static Set<String> substringPalindromes(String word) {
        List<String> lettersСombinations = new ArrayList<>();
        int wordLength = word.length();
        for (int size = 1; size <= wordLength; size++) {
            for (int start = 0; start <= wordLength - size; start++) {
                int end = start + size;
                lettersСombinations.add(word.substring(start, end));
            }
        }
        return lettersСombinations.stream().filter(x -> {
            StringBuilder stringBuilder = new StringBuilder(x);
            if (x.equals(stringBuilder.reverse().toString())) {
                return true;
            }
            return false;
        }).collect(Collectors.toSet());
    }

    public static List<Integer> perfectNumbers(int start, int end) {
        List<Integer> listOfNumber = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            listOfNumber.add(i);
        }
        return listOfNumber.stream().filter(x -> {
            int sum = 0;
            for (int i = 1; i < x; i++) {
                if (x % i == 0) {
                    sum += i;
                }
            }
            return x == sum;
        }).collect(Collectors.toList());
    }

}