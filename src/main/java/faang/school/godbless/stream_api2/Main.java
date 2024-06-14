package faang.school.godbless.stream_api2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // test first task - Construct Pairs
        List<Integer> integerList = List.of(1, 9, 3, 6, 4, 5, 1, 9, 5);
        System.out.println(StreamOperations.pairConstructor(integerList, 10));
        System.out.println();

        // test second task - Sort capitals and show them
        Map<String, String> capitals = Map.of(
                "Moscow", "Russia",
                "Denver", "Colorado",
                "Rio", "Brazil",
                "Tokyo", "Japan",
                "Berlin", "German",
                "Nairobi", "Kenya",
                "Helsinki", "Finland",
                "Oslo", "Norway"
        );
        List<String> capitalsList = StreamOperations.getCountriesAndCapitals(capitals);
        System.out.println(capitalsList);
        System.out.println();

        // test third task -
        List<String> stringsToFilterAndSortByLength = List.of("Character", "char", "book", "rest", "best");
        List<String> result = StreamOperations.filterBeginsWithAndSortByLength(stringsToFilterAndSortByLength, 'c');
        result.forEach(System.out::println);
        System.out.println();

        // test fourth task - find far friends
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("y", new ArrayList<>());
        friends.put("a", new ArrayList<>());
        friends.put("b", new ArrayList<>());
        friends.put("c", new ArrayList<>());
        friends.put("d", new ArrayList<>());
        friends.put("e", new ArrayList<>());
        friends.get("y").add("a");
        friends.get("a").add("y");
        friends.get("y").add("b");
        friends.get("b").add("y");
        friends.get("y").add("c");
        friends.get("c").add("y");
        friends.get("a").add("d");
        friends.get("d").add("a");
        friends.get("b").add("d");
        friends.get("d").add("b");
        friends.get("d").add("e");
        friends.get("e").add("d");
        Set<List<String>> friendsPairs = StreamOperations.findUnknownFriends(friends);
        System.out.println(friendsPairs);
        System.out.println();

        // test fifth task - find average salary of each department
        Employee employee1 = new Employee("First", "IT", 234);
        Employee employee2 = new Employee("Second", "IT", 2345);
        Employee employee3 = new Employee("Third", "HR", 546);
        Employee employee4 = new Employee("Fourth", "HR", 345);
        Employee employee5 = new Employee("Fifth", "Sales", 542);
        Employee employee6 = new Employee("Sixth", "Sales", 256);
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        System.out.println(StreamOperations.getAverageSalaryByDepartment(employees));
        System.out.println();

        // test sixth task - filter by alphabet and sort by length
        List<String> stringsToSortByAlphabet = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(StreamOperations.filterByAlphabetAndSortByLength(stringsToSortByAlphabet, alphabet));
        System.out.println();

        // test seventh task - convert int to binary strings
        List<Integer> integersToConvertToBinaryString = List.of(1, 5, 23, 6, 87, 8);
        System.out.println(StreamOperations.binaryConverter(integersToConvertToBinaryString));
        System.out.println();

        // test eighth task - find all palindromes in given range
        System.out.println(StreamOperations.findPalindromeIntegersInRange(100, 150));
        System.out.println();

        // test ninth task - find all palindromes in string
        System.out.println(StreamOperations.findAllPalindromesInString("arosaupalanalapuasora"));
        System.out.println();

        // test tenth task - find all perfect numbers in range
        System.out.println(StreamOperations.findAllPerfectNumbersInRange(1, 1000));
    }
}
