package school.faang.сollection__stream_api__optional.bjs2_89292;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> people = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        System.out.println("Люди, которые не друзья, но имеют общих друзей: "
                + OperationWithStream.findPeopleWithCommonFriends(people));

        List<Employee> employees = List.of(
                new Employee("John", 2000, "Department1"),
                new Employee("Din", 3000, "Department2"),
                new Employee("Tom", 2700, "Department3"),
                new Employee("Ron", 2500, "Department1"),
                new Employee("Bill", 2300, "Department2")
        );
        System.out.println("Средня зарплата по отделам: " + OperationWithStream.averageSalaryByDepartment(employees));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало и конец диапазона для поиска чисел-палиндромов через пробел: ");
        int startNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();
        System.out.printf("Числа-палиндромы в диапазоне [%d, %d]: %s\n", startNumber, endNumber,
                OperationWithStream.numbersPalindromes(startNumber, endNumber));

        System.out.print("Введите строку для поиска палиндромов: ");
        String inputStringForPalindromes = scanner.next(); // "abac";
        System.out.printf("Подстроки-палиндромы, входящие в строку '%s': %s\n", inputStringForPalindromes,
                OperationWithStream.palindromeSubstrings(inputStringForPalindromes));

        System.out.print("Введите начало и конец диапазона для поиска совершенных чисел через пробел: ");
        startNumber = scanner.nextInt();
        endNumber = scanner.nextInt();
        scanner.close();
        System.out.printf("Совершенные числа в диапазоне [%d, %d]: %s", startNumber, endNumber,
                OperationWithStream.findPerfectNumbers(startNumber, endNumber));
    }
}
