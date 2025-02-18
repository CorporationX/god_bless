package bjs2_57894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Map<String, List<String>> data1 = new HashMap<>();
        insertItemToTask1(data1, "Alice", List.of("Bob", "Charlie"));
        insertItemToTask1(data1, "Bob", List.of("Alice", "David"));
        insertItemToTask1(data1, "Charlie", List.of("Alice", "David"));
        insertItemToTask1(data1, "David", List.of("Bob", "Charlie"));

        List<Pair> friendOfFriends = Utils.getFriendOfFriends(data1);
        System.out.println(friendOfFriends);
        System.out.println();

        System.out.println("Task 2");
        List<Employee> data2 = new ArrayList<>();
        insertItemToTask2(data2, "Alice", 1, "Department 1");
        insertItemToTask2(data2, "Bob", 2, "Department 2");
        insertItemToTask2(data2, "Charlie", 3, "Department 1");
        insertItemToTask2(data2, "David", 4, "Department 3");
        insertItemToTask2(data2, "Ivan", 5, "Department 3");
        insertItemToTask2(data2, "Sven", 58, "Department 2");

        Map<String, Double> averageSalaryByDepartment = Utils.getAverageSalaryByDepartment(data2);
        System.out.println(averageSalaryByDepartment);
        System.out.println();

        System.out.println("Task 3");
        int from = 100;
        int to = 200;
        System.out.printf("[%d, %d]%n", from, to);
        List<Integer> palindroms = Utils.getPalindroms(from, to);
        System.out.println(palindroms);
        System.out.println();

        System.out.println("Task 4");
        String string = "abaca";
        System.out.println(string);
        List<String> substringsPalindroms = Utils.getSubstringsPalindroms(string);
        System.out.println(substringsPalindroms);
        System.out.println();

        System.out.println("Task 5");
        from = 1;
        to = 1000;
        System.out.printf("[%d, %d]%n", from, to);
        List<Integer> perfectDigits = Utils.getPerfectDigits(from, to);
        System.out.println(perfectDigits);
        System.out.println();
    }

    private static void insertItemToTask1(Map<String, List<String>> data, String name, List<String> friends) {
        data.put(name, friends);
        System.out.printf("%s: %s%n", name, friends);
    }

    private static void insertItemToTask2(List<Employee> data, String name, double salary, String department) {
        data.add(new Employee(name, salary, department));
        System.out.printf("%s %.2f %s%n", name, salary, department);
    }
}
