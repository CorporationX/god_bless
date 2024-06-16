package faang.school.godbless.StreamAPI2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, StreamAPITestDrive> houses = new HashMap<>();

    public static void main(String[] args) {
        Map<String, String> a = Map.of("Russia", "Moscow", "Italy", "", "France", "Paris", "Germany", "Berlin");
        List<String> collect = List.of("Russia", "Moscow", "Italy", "", "France", "Paris", "Germany", "Berlin");
        List<Employee> employees = List.of(
                new Employee("Jack", 2500, "D"),
                new Employee("Kate", 4000, "F"),
                new Employee("Max", 3000, "F")
        );
        List<Character> s = List.of('R', 'u', 's', 'i', 'a');

        StreamAPITestDrive.countriesAndCapitals(a);
        System.out.println(StreamAPITestDrive.stringFilter(collect, 'I'));
        System.out.println(StreamAPITestDrive.averageSalary(employees));
        System.out.println(StreamAPITestDrive.sortByAlphabet(collect, s));
        System.out.println(StreamAPITestDrive.numbersToStrings(List.of(1, 2, 3)));
        System.out.println(StreamAPITestDrive.integersBySum(List.of(1, 2, 3, 4, 5, 5, 6, 7, 8, 9), 10));
    }
}
