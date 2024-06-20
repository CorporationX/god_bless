package faang.school.godbless.streamAPI2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TranStreamAPI tranStreamAPI = new TranStreamAPI();

        List<Integer> Numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23);
        tranStreamAPI.searchSumPairTarget(Numbers, 14).forEach(System.out::println);

        Map<String, String> CapitalByCountry = Map.of(
                "c", "asd",
                "b", "tr",
                "a", "lk",
                "d", "py"
        );
        tranStreamAPI.sortCapitalByCountry(CapitalByCountry).forEach(System.out::println);

        List<String> someRandomStrings = List.of("asdfg", "aghjh", "agfjhkjh", "wey", "yhgdf", "etjyh", "rtyh");
        tranStreamAPI.findByCharAndSort(someRandomStrings, 'a').forEach(System.out::println);

        Map<String, List<String>> peopleWithFriends = Map.of(
                "1", List.of("1", "2", "3", "4"),
                "2", List.of("5", "6", "7", "8"),
                "3", List.of("9", "10", "11", "12"),
                "4", List.of("1", "0", "0", "0"),
                "5", List.of("2", "9", "6", "2"),
                "6", List.of("6", "12", "13", "14")
        );
        tranStreamAPI.searchingFamiliarPeople(peopleWithFriends).forEach(System.out::println);

        List<Employee> employees = Arrays.asList(
                new Employee("name1", 300, "d1"),
                new Employee("name2", 200, "d1"),
                new Employee("name3", 400, "d1"),
                new Employee("name4", 700, "t1"),
                new Employee("name5", 300, "t1"),
                new Employee("name6", 200, "t1"),
                new Employee("name7", 500, "t1"),
                new Employee("name8", 800, "t1"),
                new Employee("name9", 900, "d1")
        );
        tranStreamAPI.middleSalaryForDepartment(employees).forEach((k, v) -> System.out.println(k + ": " + v));

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        tranStreamAPI.convertNumberToBinary(nums).forEach(System.out::println);

        tranStreamAPI.searchNumberPalindromeInRange(0, 10000).stream().forEach(System.out::println);
    }
}
