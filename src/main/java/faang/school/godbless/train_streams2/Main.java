package faang.school.godbless.train_streams2;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        StreamsComputer.sortedCountriesCapitals(Map.of(
                "Russia", "Moscow",
                "Czech Republic", "Prague",
                "United Kingdom", "London")
        );

        System.out.println("===");

        StreamsComputer.startWithCharLengthSorted(List.of(
                "London", "Los Angeles", "Kaliningrad", "Amsterdam"),
                'L').forEach(System.out::println);

        Map<String, Double> avgSalaryByDepartment = StreamsComputer.departmentAverageSalaries(List.of(
                new Employee("Nikita", "IT", 120000),
                new Employee("Matvey", "IT", 80000),
                new Employee("Arman", "Sales", 70000),
                new Employee("Denis", "Sales", 50000),
                new Employee("Ivan", "Marketing", 60000),
                new Employee("Alex", "Marketing", 40000)
        ));
        avgSalaryByDepartment.forEach((k, v) -> System.out.println(k + " --- " + v));

        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println(StreamsComputer.fromAlphabetLengthSorted(strings, alphabet));

        System.out.println(StreamsComputer.intToBinaryString(List.of(1, 2, 3, 4, 5)));

//        System.out.println(StreamsComputer.allPalindromesInRange(100, 203));

        System.out.println(StreamsComputer.pairsAddingToTarget(List.of(1, 9, 3, 6, 4), 10));

        System.out.println(StreamsComputer.notFriendsWithCommonFriends(Map.of(
                "Nikita", List.of("Denis", "Matvey"),
                "Denis", List.of("Mike", "Emma"),
                "Arman", List.of("Denis", "Peter")
        )));
    }
}
