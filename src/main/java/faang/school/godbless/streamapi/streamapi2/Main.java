package faang.school.godbless.streamapi.streamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //1
        List<Integer> integers = List.of(1, 9, 3, 6, 4, 5, 5);
        int targetSum = 10;
        System.out.println(TaskService.findUniqueIntPairs(integers, targetSum));

        //2
        Map<String, String> countryNameToCapitalName = Map.of(
                "Russia", "Moscow",
                "Sweden", "Stockholm",
                "Poland", "Warsaw");
        System.out.println(TaskService.sortByKeyAndGetValuesList(countryNameToCapitalName));

        //3
        List<String> strings = List.of("c", "C", "char", "java", "cxx");
        System.out.println(TaskService.filterByStartCharAndSortByLength(strings, 'c'));

        //4
        /* Полагаю, что если у пользователя есть друг, значит и у этого друга есть данный
         пользователь в списке друзей (нет односторонней дружбы) */
        Map<String, List<String>> userToFriendsMap = Map.of(
                "User 1", List.of(),
                "User 2", List.of("User 3"),
                "User 3", List.of("User 2", "User 4", "User 5"),
                "User 4", List.of("User 3", "User 5"),
                "User 5", List.of("User 3", "User 4"));
        System.out.println(TaskService.findUsersNotFriendsWithMutualFriends(userToFriendsMap));

        //5
        List<Employee> employees = List.of(
                new Employee("Eml1", 50000.27, "Dept1"),
                new Employee("Eml2", 25000.315, "Dept1"),
                new Employee("Eml3", 25000.007, "Dept1"),
                new Employee("Eml4", 50000.27, "Dept2")
        );
        System.out.println(TaskService.findAvgSalaryByDept(employees));

        //6
        List<String> strings1 = List.of("apple", "bananaX", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] requiredFormAlphabet = alphabet.toCharArray();
        System.out.println(TaskService.filterByAlphabetAndSortByLength(strings1, requiredFormAlphabet));

        //7
        List<Integer> integers1 = List.of(20, 375);
        System.out.println(TaskService.convertIntegersToBinaryFormStrings(integers1));

        //8
        System.out.println(TaskService.findPalindromes(1, 213));
    }
}
