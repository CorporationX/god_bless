package school.faang.stream3;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 19.06.2025
 */
public class Main {

    public static final String ALICE = "Alice";
    public static final String CHARLIE = "Charlie";
    public static final String DAVID = "David";
    public static final String BOB = "Bob";

    public static void main(String[] args) {
        var friendsByName = Map.of(
                ALICE, Set.of(BOB, CHARLIE),
                BOB, Set.of(ALICE, DAVID),
                CHARLIE, Set.of(ALICE, DAVID),
                DAVID, Set.of(BOB, CHARLIE)
        );
        var peopleWithMutualFriends = Operations.findPeopleWithMutualFriends(friendsByName);
        System.out.println(peopleWithMutualFriends);

        var employees = List.of(
                new Employee(ALICE, 250, "dep1"),
                new Employee(BOB, 190, "dep1"),
                new Employee(CHARLIE, 270, "dep1"),
                new Employee(DAVID, 340, "dep2"),
                new Employee("Alex", 150, "dep2"),
                new Employee("Phillip", 210, "dep2")
        );
        var averageSalaryByDepartment = Operations.findAverageSalaryByDepartment(employees);
        System.out.println(averageSalaryByDepartment);

        var palindromes = Operations.findPalindromes(100, 200);
        System.out.println(palindromes);

        var substringPalindromes = Operations.findSubstringPalindromes("abac");
        System.out.println(substringPalindromes);

        var perfectNumbers = Operations.findPerfectNumbers(1, 1000);
        System.out.println(perfectNumbers);
    }
}
