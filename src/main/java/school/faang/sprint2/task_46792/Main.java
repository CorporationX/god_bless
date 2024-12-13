package school.faang.sprint2.task_46792;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamTraining streamTraining = new StreamTraining();
        List<Employee> employees = generateMockData();

        Map<String, Double> avgSalaryByDepartment = streamTraining.avgSalaryByDepartment(employees);
        avgSalaryByDepartment.entrySet().stream().forEach(System.out::println);

        List<Integer> palindrome = streamTraining.findPalindrome(100, 200);
        palindrome.stream().forEach(System.out::println);
    }

    public static List<Employee> generateMockData() {
        return Arrays.asList(
                new Employee("Alice", 75000, "Engineering"),
                new Employee("Bob", 60000, "HR"),
                new Employee("Charlie", 82000, "Engineering"),
                new Employee("Diana", 58000, "Marketing"),
                new Employee("Eve", 97000, "Engineering"),
                new Employee("Frank", 54000, "Finance"),
                new Employee("Grace", 67000, "HR"),
                new Employee("Hank", 72000, "Engineering"),
                new Employee("Ivy", 88000, "Marketing"),
                new Employee("Jack", 66000, "Finance"),
                new Employee("Kim", 64000, "HR"),
                new Employee("Liam", 74000, "Engineering"),
                new Employee("Mona", 51000, "Marketing"),
                new Employee("Nora", 87000, "Engineering"),
                new Employee("Oscar", 63000, "Finance"),
                new Employee("Pam", 76000, "Engineering"),
                new Employee("Quinn", 90000, "Marketing"),
                new Employee("Rick", 56000, "HR"),
                new Employee("Sam", 78000, "Engineering"),
                new Employee("Tina", 58000, "Finance")
        );
    }
}
