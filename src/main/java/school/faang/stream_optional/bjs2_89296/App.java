package school.faang.stream_optional.bjs2_89296;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        //Найдите людей с общими друзьями
        Map<String, List<String>> map = new HashMap<>(Map.of(
                "Alice", new ArrayList<>(Arrays.asList("Bob", "Charlie")),
                "Bob", new ArrayList<>(Arrays.asList("Alice", "David")),
                "Charlie", new ArrayList<>(Arrays.asList("Alice", "David")),
                "David", new ArrayList<>(Arrays.asList("Bob", "Charlie"))
        ));

        System.out.println(Operations.getPersonsNotFriendsWithMutualFriends(map));

        //Найдите среднюю зарплату для каждого отдела
        final List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Olya", 100, "IT"),
                new Employee("Oleg", 150, "IT"),
                new Employee("Ivan", 240, "HR"),
                new Employee("Anton", 110, "HR"),
                new Employee("Nina", 340, "ACC"),
                new Employee("Nikolay", 550, "ACC")
        ));

        System.out.println(Operations.getAvgSalaryByDepartment(employeeList));

        //Найдите числа-палиндромы
        System.out.println(Operations.getPalindromeBetweenTwoInts(100, 200));

        //Найдите подстроки-палиндромы
        System.out.println(Operations.getPalindromesFromString("abac"));

        //Найдите совершенные числа
        System.out.println(Operations.getPerfectNumbers(1, 1000));
    }
}