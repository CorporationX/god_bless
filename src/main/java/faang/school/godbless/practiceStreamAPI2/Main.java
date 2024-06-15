package faang.school.godbless.practiceStreamAPI2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamApiMethods streamApiMethods = new StreamApiMethods();

        List<Integer> nums = List.of(1, 9, 3, 6, 4, 5);

        Map<String, String> countries = Map.of("Russia", "Moscow", "England",
                "London", "Spain", "Madrid");

        Map<String, List<String>> peoples = Map.of("Nikita", List.of("Ivan, Oleg, Anna"),
                "Andrey", List.of("Ivan, Oleg, Anna"), "Oleg", List.of("Nikita, Andrey, Anna"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Artur", 1000, "IT"));
        employees.add(new Employee("Igor", 250, "IT"));
        employees.add(new Employee("Ivan", 250, "HR"));
        employees.add(new Employee("Oleg", 2000, "HR"));

        List<String> words = List.of("apple", "banana", "123", "dog", "cat");

        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        List<Character> alphabet = new ArrayList<>();
        for (char symbol : alphabetString.toCharArray()) {
            alphabet.add(symbol);
        }

        streamApiMethods.printSortedListCountryCapital(countries);
        System.out.println(streamApiMethods.pairsForTargetNum(10, nums));

        System.out.println(streamApiMethods.findPeopleNotFriendsButWithMutualFriends(peoples));

        System.out.println(streamApiMethods.countAvgSalaryForDepartments(employees));

        System.out.println(streamApiMethods.filterAndSortStringsByAlphabet(words, alphabet));

        System.out.println(streamApiMethods.palindromeNumbersInTheRange(1, 1000));
    }
}
