package school.faang.task_60188;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friendsConnectionsV1 = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        Map<String, List<String>> friendsConnectionsV2 = Map.ofEntries(
                Map.entry("Alice", List.of("Bob", "Charlie", "Mike")),
                Map.entry("Bob", List.of("Alice", "David", "John")),
                Map.entry("Charlie", List.of("Alice", "David")),
                Map.entry("David", List.of("Bob", "Charlie")),
                Map.entry("John", List.of("Bob", "Liza", "Mike")),
                Map.entry("Mike", List.of("John", "Alice")),
                Map.entry("Liza", List.of("John")),
                Map.entry("Emma", List.of("Michael", "Sarah", "Tom")),
                Map.entry("Michael", List.of("Emma", "Sarah", "William")),
                Map.entry("Sarah", List.of("Emma", "Michael", "James")),
                Map.entry("James", List.of("Sarah", "William", "Robert")),
                Map.entry("William", List.of("Michael", "James", "Richard")),
                Map.entry("Robert", List.of("James", "Richard", "Charles")),
                Map.entry("Richard", List.of("William", "Robert", "Thomas")),
                Map.entry("Thomas", List.of("Richard", "Charles", "Donald")),
                Map.entry("Charles", List.of("Robert", "Thomas", "Harold")),
                Map.entry("Donald", List.of("Thomas", "Harold", "Frank")),
                Map.entry("Harold", List.of("Charles", "Donald", "Gary")),
                Map.entry("Frank", List.of("Donald", "Gary", "Larry")),
                Map.entry("Gary", List.of("Harold", "Frank", "Jerry")),
                Map.entry("Jerry", List.of("Gary", "Larry", "Joseph")),
                Map.entry("Larry", List.of("Frank", "Jerry", "Edward")),
                Map.entry("Joseph", List.of("Jerry", "Edward", "Brian")),
                Map.entry("Edward", List.of("Larry", "Joseph", "Kevin")),
                Map.entry("Brian", List.of("Joseph", "Kevin", "Mark")),
                Map.entry("Kevin", List.of("Edward", "Brian", "Steven")),
                Map.entry("Mark", List.of("Brian", "Steven", "Paul")),
                Map.entry("Steven", List.of("Kevin", "Mark", "Daniel")),
                Map.entry("Paul", List.of("Mark", "Daniel", "Matthew")),
                Map.entry("Daniel", List.of("Steven", "Paul", "Andrew")),
                Map.entry("Matthew", List.of("Paul", "Andrew", "Joshua")),
                Map.entry("Andrew", List.of("Daniel", "Matthew", "Nicholas")),
                Map.entry("Joshua", List.of("Matthew", "Nicholas", "Christopher")),
                Map.entry("Nicholas", List.of("Andrew", "Joshua", "Anthony")),
                Map.entry("Christopher", List.of("Joshua", "Anthony", "Joseph")),
                Map.entry("Anthony", List.of("Nicholas", "Christopher", "Michael"))
        );

        Set<List<String>> commonFriendsPairsV1 = ListOperations.findPeopleWithCommonFriends(friendsConnectionsV1);
        System.out.printf("Users recommendation list for notifications: \n\t%s\n", commonFriendsPairsV1);

        Set<List<String>> commonFriendsPairsV2 = ListOperations.findPeopleWithCommonFriends(friendsConnectionsV2);
        System.out.printf("Users recommendation list for notifications: \n\t%s\n", commonFriendsPairsV2);

        List<Employee> employees = List.of(
                new Employee("John Smith", 50000, "Engineering"),
                new Employee("Sarah Johnson", 60000, "Marketing"),
                new Employee("Michael Brown", 70000, "Engineering"),
                new Employee("Emma Wilson", 55000, "HR"),
                new Employee("David Miller", 65000, "Sales"),
                new Employee("Olivia Davis", 45000, "Marketing"),
                new Employee("William Anderson", 75000, "Engineering"),
                new Employee("Ava Garcia", 48000, "HR"),
                new Employee("James Rodriguez", 58000, "Sales"),
                new Employee("Sophia Martinez", 52000, "Marketing")
        );

        Map<String, Double> avgDepartmentFee = ListOperations.avgDepartmentFee(employees);
        System.out.println("Average fee per department:");
        avgDepartmentFee.forEach((department, avgFee) ->
                System.out.printf("\t%s: %.1f\n", department, avgFee));

        Map<Integer, Integer> range = Map.of(100, 200);
        List<Integer> palindromesNumbers = ListOperations.palindromesNumbers(range);
        System.out.printf("Palindromes within a given range: \n\t%s\n", palindromesNumbers);

        String inputWord = "abac";
        Set<String> palindromesSubStrings = ListOperations.searchPalindromesSubString(inputWord);
        System.out.printf("Palindromes sub strings in input word: \n\t%s\n", palindromesSubStrings);

        Map<Integer, Integer> rangeNumbers = Map.of(1, 1000);
        List<Integer> perfectNumbers = ListOperations.searchPerfectNumbers(rangeNumbers);
        System.out.printf("Perfect numbers within a given range: \n\t%s\n", perfectNumbers);
    }
}
