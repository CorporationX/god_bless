package faang.school.godbless.BJS2_10778;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);
        List<String> lines = List.of("We suggest you adjust your records accordingly.",
                "What on earth are you talking about?",
                "Locals tucked cash into collection boxes at Safeway, Eegee’s, and Dunkin' Donuts.",
                "One Russian Olympic official has publicly called for Rodchenkov to be shot.",
                "What happened: In four separate incidents since 9/11, terror plots either failed or were executed without disruption.");

        Map<String, String> country = Map.of(
                "Russia", "Moscow",
                "Germany", "Berlin",
                "Poland", "Warsaw",
                "Japan", "Tokyo");

        System.out.println(SomeClass.findUniquePairsOfNumbers(numbers, 10));

        SomeClass.printCapitalsOfCountries(country).forEach(System.out::println);
        System.out.println("_________________________________________________");
        SomeClass.filterLinesStartWithChar(lines, 'W').forEach(System.out::println);



        Map<String, List<String>> userToFriendsMap = Map.of(
                "User 1", List.of(),
                "User 2", List.of("User 3"),
                "User 3", List.of("User 2", "User 4", "User 5"),
                "User 4", List.of("User 3", "User 5"),
                "User 5", List.of("User 3", "User 4"));
        System.out.println(SomeClass.findUsersNotFriend(userToFriendsMap));


        List<Employee> employees = List.of(
                new Employee("Employee1", 75000, "Department1"),
                new Employee("Employee2", 55000, "Department2"),
                new Employee("Employee3", 25000, "Department2"),
                new Employee("Employee4", 150000, "Department1")
        );
        System.out.println(SomeClass.averageSalaryOnDepartment(employees));

        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] requiredFormAlphabet = alphabet.toCharArray();
        System.out.println(SomeClass.filterByAlphabetAndSort(strings, requiredFormAlphabet));


        List<Integer> integers = List.of(20, 375);
        System.out.println(SomeClass.convertIntegerToBinary(integers));


        System.out.println(SomeClass.findPalindromes(1, 200));

    }
}
