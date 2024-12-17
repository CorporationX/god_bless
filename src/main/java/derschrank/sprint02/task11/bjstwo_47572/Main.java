package derschrank.sprint02.task11.bjstwo_47572;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTask 01");
        System.out.println("Найдите людей с общими друзьями");
        Map<String, List<String>> personsWithTheirFriends = new HashMap<>();
        personsWithTheirFriends.put("Alice", List.of("Bob", "Charlie"));
        personsWithTheirFriends.put("Bob", List.of("Alice", "David"));
        personsWithTheirFriends.put("Charlie", List.of("Alice", "David"));
        personsWithTheirFriends.put("David", List.of("Bob", "Charlie"));
        personsWithTheirFriends.put("Ivan", List.of("Charlie", "Bob"));
        System.out.println("Data: " + personsWithTheirFriends);
        System.out.println("Assert: [(Alice, David), (Bob, Charlie)]");
        StreamApi3 api = new StreamApi3();
        System.out.println("Fact: " + api.taskOneFindCommonFriends(personsWithTheirFriends));


        System.out.println("\nTask 02");
        System.out.println("Найдите среднюю зарплату для каждого отдела");
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Ivan", 2010, "it"));
        employees.add(new Employee("Pavel", 2020, "it"));
        employees.add(new Employee("Smavel", 2030, "it"));
        employees.add(new Employee("Ivan A", 1210, "hr"));
        employees.add(new Employee("Pavel A", 1220, "hr"));
        employees.add(new Employee("Smavel A", 1230, "hr"));
        employees.add(new Employee("Ivan B", 3010, "ceo"));
        employees.add(new Employee("Pavel B", 3020, "ceo"));
        employees.add(new Employee("Smavel B", 3030, "ceo"));
        System.out.println("Data: " + employees);
        System.out.println("Fact: " + api.taskTwoAverageSalary(employees));

        System.out.println("\nTask 03");
        System.out.println("Найдите числа-палиндромы");
        int beginForPolindrom = 100;
        int endForPolindrom = 200;
        System.out.println("Data: " + beginForPolindrom + ", " + endForPolindrom);
        System.out.println("Fact: " + api.taskThreeFindPolindromNumbers(beginForPolindrom, endForPolindrom));

        System.out.println("\nTask 04");
        System.out.println("Найдите подстроки-палиндромы");
        String stringForSubStrings = "abac mama mila ramu";
        System.out.println("Data: " + stringForSubStrings);
        System.out.println("Fact: " + api.taskFourFindPolindrom(stringForSubStrings));

        System.out.println("\nTask 05");
        System.out.println("Найдите совершенные числа");
        int beginForSuperNumber = 1;
        int endForSuperNumber = 1000;
        System.out.println("Data: " + beginForSuperNumber + ", " + endForSuperNumber);
        System.out.println("Fact: " + api.taskFiveFindSuperNumber(beginForSuperNumber, endForSuperNumber));

    }
}
