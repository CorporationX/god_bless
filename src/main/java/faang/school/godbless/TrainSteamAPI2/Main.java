package faang.school.godbless.TrainSteamAPI2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 7, 8, 9, 1, 8, 3, 10, 9, 1, 7, 7, 3);

        /*numbers.stream()
                .sorted((num1, num2) -> num2 - num1)
                .forEach(num -> System.out.println(num));*/

        Set<List<Integer>> uniquePairs = StreamMethods.uniquePairs(numbers, 10);
        System.out.println("Уникальные значения: " + uniquePairs);

        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Russia", "Mosсow");
        countryCapital.put("Austria", "Vienna");
        countryCapital.put("Italy", "Rome");
        countryCapital.put("Belgium", "Brussels");
        countryCapital.put("Japan", "Tokyo");

        List<String> capitalsSort = StreamMethods.capitalsSort(countryCapital);
        System.out.println(capitalsSort);

        List<String> words = Arrays.asList("pineapple", "banana", "orange", "pear", "avocado", "potato");
        List<String> sortStringsByLength = StreamMethods.sortStringsByLength(words, 'p');
        System.out.println(sortStringsByLength);

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", Arrays.asList("Daniel", "Join", "Emma"));
        friends.put("Jack", Arrays.asList("Bill", "Join", "Eva"));
        friends.put("Emily", Arrays.asList("Lucy", "Olivia", "James")); //нет повторных друзей
        friends.put("Tom", Arrays.asList("Emily", "Join", "Eva"));
        friends.put("Daniel", Arrays.asList("Alice", "Jane", "Eva"));
        Set<List<String>> friendsFriends = StreamMethods.friendsFriends(friends);
        System.out.println("Друзья друзей: " + friendsFriends);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Сергей", 40000, "отдел работ"));
        employees.add(new Employee("Алёна", 50000, "отдел работ"));
        employees.add(new Employee("Василий", 60000, "отдел работ"));
        employees.add(new Employee("Iгорь", 20000, "отдел закупок"));
        employees.add(new Employee("Лидия", 120000, "отдел закупок"));

        Map<String, Double> averageDepartmentSalary = StreamMethods.averageDepartmentSalary(employees);
        System.out.println(averageDepartmentSalary);
    }
}
