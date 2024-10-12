package school.BJS2_34824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> mapOfFriends = new HashMap<>();
        mapOfFriends.put("Alice", Arrays.asList("Bob", "Charlie"));
        mapOfFriends.put("Bob", Arrays.asList("Alice", "David"));
        mapOfFriends.put("Charlie", Arrays.asList("Alice", "David"));
        mapOfFriends.put("David", Arrays.asList("Bob", "Charlie"));

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
        return mapPeopleWithFriends.entrySet().stream().map(entry -> mapPeopleWithFriends.entrySet().stream()
                .filter(person -> person.getValue().stream().anyMatch(friend -> person.getValue().contains(friend)))
                .filter(person -> !person.getValue().contains(entry.getKey()))
                .map(currentEntry -> currentEntry.getKey()).toList()
        ).collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryForEachDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(),
                Collectors.averagingDouble(employee_of_department -> employee_of_department.getSalary())));
    }

    public static List<Integer> numberPalindromes(int start, int end) {
        return IntStream.range(start, end + 1).filter(number -> findingThePalindromeNumber(number)).boxed().toList();
    }

    public static Set<String> substringPalindromes(String word) {
        final Set<String> lettersСombinations = new HashSet<>();
        IntStream.range(0, word.length())
                .forEach(i -> IntStream.range(i + 1, word.length() + 1)
                        .mapToObj(j -> word.substring(i, j)).filter(x -> checkPolindromLine(x))
                        .forEach(x -> lettersСombinations.add(x)));
        return lettersСombinations;
    }

    public static List<Integer> perfectNumbers(int start, int end) {
        return IntStream.range(start, end).filter(number -> findingPerfectNumber(number)).boxed().toList();

    }

    private static boolean findingThePalindromeNumber(int number) {
        int reversed = 0;
        int k = number;
        while (k != 0) {
            reversed = reversed * 10 + k % 10;
            k /= 10;
        }
        return number == reversed;
    }

    private static boolean findingPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return number == sum;
    }

    private static boolean checkPolindromLine(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        if (line.equals(stringBuilder.reverse().toString())) {
            return true;
        }
        return false;
    }

}