package faang.school.godbless.streams.task_2;

import faang.school.godbless.streams.task_2.model.Employee;
import faang.school.godbless.streams.task_2.utils.StreamUsageExample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StreamUsageExample streamUsageExample = new StreamUsageExample();
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        //task 1
        System.out.println("Задание 1: ");
        streamUsageExample.printTermsForNumber(numbers, 10);
        System.out.println();
        //task 2
        System.out.println("Задание 2: ");
        Map<String, String> countries = Map.of(
                "Russia", "Moskva",
                "Belarus", "Minsk",
                "Ukraina", "Kiev",
                "Kazahstan", "Astana"
        );
        System.out.println(streamUsageExample.getCapitalsList(countries));
        System.out.println();
        //task 3
        System.out.println("Задание 3: ");
        List<String> strings = Arrays.asList("dsafdsaf", "fdajghivbu", "d", "sdsfg");
        System.out.println(streamUsageExample.getSortedWordsListStartedWith('d', strings));
        System.out.println();
        //task 4
        System.out.println("Задание 4: ");
        Map<String, List<String>> friends = new HashMap<>();
        String denis = "Denis";
        String maga = "Maga";
        String katya = "Katya";
        String ahmed = "Ahmed";
        friends.put(denis, List.of(maga, katya));
        friends.put(maga, List.of(denis, ahmed));
        friends.put(katya, List.of(denis));
        friends.put(ahmed, List.of(maga));
        streamUsageExample.findPairsWithMutualFriends(friends)
                .forEach((key, value) -> System.out.println(key + "-" + value));
        System.out.println();
        //task 5
        System.out.println("Задание 5: ");
        List<Employee> employees = Arrays.asList(
                new Employee("emp1", 1500, "dep1"),
                new Employee("emp1", 1800, "dep3"),
                new Employee("emp1", 2500, "dep2"),
                new Employee("emp1", 1000, "dep1")
        );
        streamUsageExample.getAverageSalariesOfDepartments(employees)
                .forEach((key, value) -> System.out.println(key + "-" + value));
        System.out.println();
        //task 6
        System.out.println("Задание 6: ");
        List<String> words = Arrays.asList("apple", "banana", "123", "dog", "cat");
        String[] alphabet = {"a", "b", "c,", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        System.out.println(streamUsageExample.getSortedWordsListContainsLetters(words, alphabet));
        System.out.println();
        //task 7
        System.out.println("Задание 7: ");
        System.out.println(streamUsageExample.getListOfBinaryNumbers(numbers));
        System.out.println();
        //task 8
        System.out.println("Задание 8: ");
        System.out.println(streamUsageExample.getPalindromeNumbers(100, 200));
        System.out.println();
        //task 9
        System.out.println("Задание 9: ");
        String palindrome = "arozaupalanalapuazora";
        System.out.println(streamUsageExample.getPalindromeStrings(palindrome));
        System.out.println();
        //task 10
        System.out.println("Задание 10: ");
        System.out.println(streamUsageExample.getPerfectNumbers(0, 1000));
        System.out.println();
    }
}