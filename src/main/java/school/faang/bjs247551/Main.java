package school.faang.bjs247551;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(substringPalindrome("abac"));
        System.out.println("--------------------------------------------------------");
        Employee alice = new Employee("Alice", 60000D, "IT");
        Employee bob = new Employee("Bob", 50000D, "HR");
        Employee charlie = new Employee("Charlie", 70000D, "IT");
        Employee diana = new Employee("Diana", 80000D, "Finance");
        Employee eve = new Employee("Eve", 55000D, "HR");
        List<Employee> employees = Arrays.asList(alice, bob, charlie, diana, eve);
        Map<String, Double> stringDoubleMap = alice.averageSalary(employees);
        System.out.println(stringDoubleMap);

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "David"));
        friendsMap.put("David", Arrays.asList("Bob", "Charlie"));

        System.out.println(mutualFriends(friendsMap));
    }

    public static Set<List<String>> mutualFriends(Map<String, List<String>> map) {
        Set<List<String>> result = new HashSet<>();
        Set<String> names = map.keySet();
        for (String name : names) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (name.equals(key)) {
                    break;
                }
                if (!value.contains(name)) {
                    result.add(List.of(name, key));
                }
            }
        }
        return result;
    }

    public static List<Integer> palindrome(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(el -> {
                    int temp = el;
                    int result = 0;
                    while (temp != 0) {
                        result = result * 10 + temp % 10;
                        temp /= 10;
                    }
                    return result == el;
                })
                .boxed()
                .toList();
    }

    public static Set<String> substringPalindrome(String word) {
        Set<String> result = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            result.add(String.valueOf(word.charAt(i)));
            for (int j = i + 1; j < n; j++) {
                String substring = word.substring(i, j);
                StringBuilder sb = new StringBuilder(substring).reverse();
                if (sb.toString().equals(substring)) {
                    result.add(substring);
                }
            }
        }
        return result;
    }

    public static List<Integer> perfectNumber(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(el -> {
                    if (el % 2 == 1) {
                        return false;
                    }
                    int result = 0;
                    for (int i = 1; i <= el / 2; i++) {
                        if (el % i == 0) {
                            result += i;
                        }
                    }
                    return result == el;
                })
                .boxed()
                .toList();
    }

}
