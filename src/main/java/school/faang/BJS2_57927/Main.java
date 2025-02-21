package school.faang.BJS2_57927;

import java.util.List;
import java.util.Map;

public class Main {
    private static final int START_PALINDROME_NUM = 100;
    private static final int END_PALINDROME_NUM = 200;
    private static final int START_PERFECT_NUM = 1;
    private static final int END_PERFECT_NUM = 1000;
    private static final String PALINDROME_SOURCE = "abac";

    public static void main(String[] args) {

        System.out.print("Пары людей, которые не являются друзьями, но имеют общих друзей:\n");
        String person1 = "Alice";
        String person2 = "Bob";
        String person3 = "Charlie";
        String person4 = "David";
        List<String> friendsPerson1 = List.of(person2, person3);
        List<String> friendsPerson2 = List.of(person1, person4);
        List<String> friendsPerson3 = List.of(person1, person4);
        List<String> friendsPerson4 = List.of(person2, person3);
        Map<String, List<String>> friendshipData = Map.of(person1, friendsPerson1,
                person2, friendsPerson2,
                person3, friendsPerson3,
                person4, friendsPerson4);
        Map<String, String> map = ListOperations.findPeopleWithMutualFriends(friendshipData);
        System.out.printf("%s\n", map);
        System.out.print("--------------------------\n");

        System.out.print("Средняя зарплата в каждом департаменте:\n");
        Employee employee1 = new Employee("John Smith", 100000, "IT");
        Employee employee2 = new Employee("Emily Johnson", 80000, "HR");
        Employee employee3 = new Employee("Michael Brown", 90000, "Marketing");
        Employee employee4 = new Employee("Linda Davis", 75000, "IT");
        Employee employee5 = new Employee("David Wilson", 120000, "HR");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);
        Map<String, Double> averageSalary = ListOperations.findAverageSalaryForEachDepartment(employees);
        System.out.printf("%s\n", averageSalary);
        System.out.print("--------------------------\n");

        System.out.printf("Числа-палиндромы в диапазоне от %d до %d:\n", START_PALINDROME_NUM, END_PALINDROME_NUM);
        List<Integer> palindromeNumbers =
                ListOperations.findPalindromicNumbers(START_PALINDROME_NUM, END_PALINDROME_NUM);
        System.out.printf("%s\n", palindromeNumbers);
        System.out.print("--------------------------\n");

        System.out.printf("Подстроки строки %s, которые являются палиндромами:", PALINDROME_SOURCE);
        List<String> palindromes = ListOperations.findPalindromeSubstrings(PALINDROME_SOURCE);
        System.out.printf("%s\n", palindromes);
        System.out.print("--------------------------\n");

        System.out.printf("Совершенные числа от %d до %d\n", START_PERFECT_NUM, END_PERFECT_NUM);
        List<Integer> perfectNumbers = ListOperations.findPerfectNumbers(START_PERFECT_NUM, END_PERFECT_NUM);
        System.out.printf("%s\n", perfectNumbers);
    }
}
