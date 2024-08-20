package faang.school.godbless.BJS2_22500;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);
        System.out.println(Streams.findUniquePairsSumIsEqualTarget(numbers, 10));

        Map<String, String> countryByCapital = Map.of(
                "Russia", "Moscow",
                "America", "Washington",
                "Denmark", "Копенгаген"
        );
        System.out.println();
        Streams.sortAndPrintCapitals(countryByCapital);
        System.out.println();

        System.out.println(Streams.sortByLengthWithFilterByTarget(List.of("Robert", "Serenaaa", "Sultan"), 'S'));

        Map<String, List<String>> people = Map.of(
                "Robert", List.of("Denis", "Sultan", "Evgenii"),
                "Max", List.of("Kent", "Klark", "Denis"),
                "Sasha", List.of("Pupa", "Lupa", "Chmonya"),
                "Gosha", List.of("Lupa", "Gennadiy", "Piotr")
        );
        System.out.println(Streams.findPairsWhoNotFriendsButHaveMutualFriends(people));

        List<Employee> employees = List.of(
                new Employee("Robert", "A", 12000),
                new Employee("Robert", "A", 25000),
                new Employee("Robert", "A", 56000),
                new Employee("Robert", "B", 10000),
                new Employee("Robert", "B", 25000)
        );
        System.out.println(Streams.getMapDepartmentByAverageSalary(employees));

        List<String> strings = List.of(
                "sultan01", "abc", "dima", "petr"
        );
        char[] alphabet = {'a', 'b', 'c', 'd', '1'};
        System.out.println(Streams.filterByAlphabetAndSortByLength(strings, alphabet));

        List<Integer> nums = List.of(1, 2, 3, 10);
        System.out.println(Streams.numbersToBinaryNumbers(nums));

        System.out.println(Arrays.toString(Streams.findPalindromesInRange(1, 1000)));
        System.out.println(Streams.findPalindromesInRange("abccbaaba"));
        System.out.println(Arrays.toString(Streams.findPerfectNumbersInRange(1, 500)));
    }
}
