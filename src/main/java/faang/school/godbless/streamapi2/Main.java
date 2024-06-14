package faang.school.godbless.streamapi2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1
        List<Integer> nums = new ArrayList<>(List.of(1, 9, 3, 6, 4, 5));
        System.out.println(SomeMethods.findAllPairs(nums, 10));

        // 2
        Map<String, String> map = new HashMap<>();
        map.put("Kazakhstan", "Astana");
        map.put("Japan", "Tokyo");
        map.put("Italy", "Rome");
        List<String> cities = SomeMethods.sortCountries(map);
        System.out.println(cities);

        // 3
        List<String> stringList = new ArrayList<>(List.of("nro", "naruto", "nagat", "obito"));
        System.out.println(SomeMethods.filterListByChar(stringList, 'n'));

        //4
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        friendsMap.put("Bob", Arrays.asList("Alice", "Eve"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "Eve"));
        friendsMap.put("David", List.of("Alice"));
        friendsMap.put("Eve", Arrays.asList("Bob", "Charlie"));
        System.out.println(SomeMethods.findPeople(friendsMap));

        // 5
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 70000, "IT"),
                new Employee("David", 80000, "Finance"),
                new Employee("Eve", 90000, "Finance"),
                new Employee("Frank", 75000, "HR")
        );
        System.out.println(SomeMethods.averageSalary(employees));

        //6
        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Set<Character> alphabet = new String(alphabetArray).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(SomeMethods.filterByAlphabet(inputStrings, alphabet));

        //7
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(SomeMethods.convertToBinary(integers));

        //8
        int start = 10, end = 200;
        System.out.println(SomeMethods.findAllPalindrome(start, end));
    }
}
