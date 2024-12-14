package school.faang.task_47484;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        /*-------------------Найдите людей с общими друзьями---------------------------*/

        Map<String, List<String>> relationships = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        Set<List<String>> friends = findNonFriendsWithCommonFriends(relationships);
        friends.forEach(System.out::println);

        /*-------------------Найдите среднюю зарплату для каждого отдела-------------------------*/

        List<Employee> employees = List.of(
                new Employee("Alice", 60000, "HR"),
                new Employee("Bob", 75000, "IT"),
                new Employee("Charlie", 50000, "Finance"),
                new Employee("David", 80000, "IT"),
                new Employee("Eve", 55000, "Marketing"),
                new Employee("Frank", 70000, "Sales"),
                new Employee("Grace", 62000, "HR"),
                new Employee("Hannah", 72000, "Finance"),
                new Employee("Ian", 68000, "Marketing"),
                new Employee("Jack", 90000, "IT")
        );

        Map<String, Double> averageSalaryByDepartment = calculateAverageSalaryByDepartment(employees);
        averageSalaryByDepartment.entrySet().forEach(System.out::println);

        /*---------------------Найдите числа-палиндромы----------------------*/

        int start = 100;
        int end = 200;
        List<Integer> palindromes = findPalindromes(start, end);
        palindromes.forEach(System.out::println);

        /*-------------------Найдите подстроки-палиндромы----------------------------*/
        String input = "abac";
        List<String> palindromicSubstrings = findPalindromicSubstrings(input);
        palindromicSubstrings.forEach(System.out::println);

        /*-------------------Найдите совершенные числа----------------------------*/

        int startTwo = 1;
        int endTwo = 1000;
        List<Integer> perfectNumbers = findPerfectNumbers(startTwo, endTwo);
        perfectNumbers.forEach(System.out::println);


    }

    public static Set<List<String>> findNonFriendsWithCommonFriends(Map<String, List<String>> usersFriends) {
        return usersFriends.keySet().stream()
                .flatMap(user -> usersFriends.keySet().stream()
                        .filter(friend -> !user.equals(friend)
                                &&
                                !usersFriends.get(user).contains(friend)
                                &&
                                usersFriends.get(user).stream().anyMatch(usersFriends.get(friend)::contains))
                        .map(friend -> {
                            List<String> pair = new ArrayList<>(Arrays.asList(user, friend));
                            Collections.sort(pair); // Сортируем для уникальности
                            return pair;
                        }))
                .collect(Collectors.toSet());
    }


    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> emp) {
        return emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));

    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(Integer::toString)
                .filter(num -> num.equals(new StringBuilder(num).reverse().toString()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> findPalindromicSubstrings(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(i -> IntStream.range(i + 1, str.length() + 1)
                        .mapToObj(j -> str.substring(i, j)))
                .flatMap(s -> s)
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Main::isPerfect)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPerfect(int number) {
        int sumOfDivisors = IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum();

        return sumOfDivisors == number;
    }
}

