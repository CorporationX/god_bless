package school.faang.bjs2_80743;

import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Намеренно не выносил логику в ф-ции
        //part 1
        Map<String, List<String>> peoples = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        Set<Pair<String, String>> result = findNonFriendMutualPairs(peoples);
        result.forEach(System.out::println);

        //part 2
        List<Employee> employees = List.of(
                new Employee("1", "1", 100),
                new Employee("2", "2", 200),
                new Employee("3", "1", 300),
                new Employee("4", "3", 400),
                new Employee("5", "2", 500),
                new Employee("6", "4", 600),
                new Employee("7", "4", 700)
        );
        System.out.println("Средние зарплаты по отделам" +
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
        );

        //part 3
        List<Integer> palindromes = new ArrayList<>();
        for (int i = 100; i < 200; i++) {
            String str = Integer.toString(i);
            if (isPalindrome(str)) {
                palindromes.add(i);
            }
        }
        System.out.println("Полиндромы: " + palindromes);

        //part 4
        char[] charts = "abac".toCharArray();
        Set<String> strPalindromes = new HashSet<>();
        for (int i = 0; i < charts.length; i++) {
            StringBuilder str = new StringBuilder();
            str.append(charts[i]);
            if (isPalindrome(str.toString())) {
                strPalindromes.add(str.toString());
            }
            for (int j = i + 1; j < charts.length; j++) {
                str.append(charts[j]);
                if (isPalindrome(str.toString())) {
                    strPalindromes.add(str.toString());
                }
            }
        }
        System.out.println("Полиндромы подстроки: " + strPalindromes);

        //part 5
        List<Integer> perfectNumbers = new ArrayList<>();
        for (int i = 1; i < 100000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                perfectNumbers.add(i);
            }
        }
        System.out.println("Идеальные числа: " + perfectNumbers);
    }

    public static Set<Pair<String, String>> findNonFriendMutualPairs(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(e1 ->
                        map.entrySet().stream()
                                .filter(e2 -> e1.getKey().compareTo(e2.getKey()) < 0)
                                .filter(e2 -> !e1.getValue().contains(e2.getKey()))
                                .filter(e2 -> e1.getValue().stream()
                                        .anyMatch(e2.getValue()::contains))
                                .map(e2 -> new Pair<>(e1.getKey(), e2.getKey()))
                )
                .collect(Collectors.toSet());
    }

    @EqualsAndHashCode
    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static boolean isPalindrome(String str) {
        return str != null && !str.isBlank() && str.contentEquals(new StringBuilder(str).reverse());
    }
}