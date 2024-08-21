package faang.school.godbless.modul2.streamapi2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1. Find all the unique pairs of numbers whose sum is equal to the specified number.
        List<Integer> numsList = List.of(1, 9, 3, 6, 4, 5);
        System.out.println("1. Find unique pairs of numbers:");
        findUniquePairs(numsList, 10).forEach(System.out::println);

        //2. Sort the countries alphabetically, and then display the names of their capitals as a list.
        Map<String, String> countryMap = Map.of("Russia", "Moscow", "Belarus", "Minsk", "Kazakhstan", "Astana");
        System.out.println("\n" + "2. Display capitals sort by countries name:");
        System.out.println(findSortCountryMap(countryMap));

        //3. Filter strings starting with a given letter and sort them by length.
        List<String> stringList = List.of("SUPER", "DISCO", "SWAG", "VIP", "DAB");
        System.out.println("\n" + "3. Filtered strings sorted by their length:");
        System.out.println(findFilterStringList(stringList, 'S'));
        System.out.println(findFilterStringList(stringList, 'D'));

        //4. Find all pairs of people who are not friends, but they have mutual friends.
        Map<String, List<String>> friends = getFriendsMap();
        System.out.println("\n" + "4. Find pairs people with joint friends:");
        findPairsWithJointFriends(friends).forEach(System.out::println);

        //5. Find the average salary for each department.
        List<Employee> employees = getEmployees();
        System.out.println("\n" + "5. Find department average salary:");
        System.out.println(findDepartmentAverageSalary(employees));

        //6. Filter strings containing only letters from alphabet and sort length.
        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println("\n" + "6. Filter strings and sort:");
        System.out.println(findFilterAndSortString(strings, alphabet));

        //7. Converts a list of integers into a list of strings, where each number is written in binary form.
        List<Integer> integerList = List.of(10, 110, 220, 103, 1);
        System.out.println("\n" + "7. Convert integers to binary:");
        System.out.println(findConvertIntToBinary(integerList));

        //8. Find all palindrome numbers from diapason.
        int a = 10;
        int b = 200;
        System.out.println("\n" + "8. Palindrome numbers from " + a + " to " + b + ":");
        System.out.println(findPalindromeNumbers(a, b));

        //9. Find all palindrome substring in sentence.
        String sentence = "Madam, Anna and Bob went to the park.";
        System.out.println("\n" + "9. Palindrome substring:");
        System.out.println(findPalindromeSubstrings(sentence));

        //10. Find all Perfect numbers from diapason.
        int x = 1;
        int y = 1000;
        System.out.println("\n" + "10. Perfect numbers from " + x + " to " + y + ":");
        System.out.println(findPerfectNumbers(x, y));
    }

    //1.
    public static Set<List<Integer>> findUniquePairs(List<Integer> numsList, Integer num) {
        return numsList.stream()
                .filter(i -> numsList.contains(num - i) && (num - i != i))
                .map(i -> Arrays.asList(i, num - i))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    //2.
    public static List<String> findSortCountryMap(Map<String, String> stringMap) {
        return stringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //3.
    private static List<String> findFilterStringList(List<String> stringList, char letter) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //4.
    public static Set<List<String>> findPairsWithJointFriends(Map<String, List<String>> friends) {
        Set<String> users = new HashSet<>(friends.keySet());
        return users.stream()
                .flatMap(user1 -> users.stream()
                        .filter(user2 -> !user1.equals(user2))
                        .filter(user2 -> !friends.get(user1).contains(user2))
                        .filter(user2 -> friends.get(user1).stream().anyMatch(friends.get(user2)::contains))
                        .map(user2 -> Stream.of(user1, user2).sorted().toList())
                )
                .collect(Collectors.toSet());
    }

    private static Map<String, List<String>> getFriendsMap() {
        Map<String, List<String>> friends = new HashMap<>();

        var ivan = "Ivan";
        var oleg = "Oleg";
        var alex = "Alex";
        var petr = "Petr";
        var vadim = "Vadim";
        var anna = "Anna";
        var katie = "Katie";

        friends.put(ivan, List.of(oleg, petr, vadim));
        friends.put(oleg, List.of(ivan, petr, alex));
        friends.put(petr, List.of(ivan, oleg, katie));
        friends.put(vadim, List.of(ivan, anna, alex));
        friends.put(alex, List.of(oleg, vadim));
        friends.put(anna, List.of(vadim, katie));
        friends.put(katie, List.of(anna, petr));

        return friends;
    }

    //5.
    public static Map<String, Double> findDepartmentAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    private static List<Employee> getEmployees() {
        var johnson = new Employee("Johnson", 250000.00, "IT");
        var williams = new Employee("Williams", 300000.00, "IT");
        var garcia = new Employee("Garcia", 75000.00, "Management");
        var miller = new Employee("Miller", 80000.00, "Management");
        var davis = new Employee("Davis", 20000.00, "Support");
        var rodriguez = new Employee("Rodriguez", 25000.00, "Support");
        var martinez = new Employee("Martinez", 60000.00, "Sales");
        var hernandez = new Employee("Hernandez", 75000.00, "Sales");
        return List.of(johnson, williams, garcia, miller, davis, rodriguez, martinez, hernandez);
    }

    //6.
    public static List<String> findFilterAndSortString(List<String> stringList, char[] letters) {
        var lettersStr = new String(letters);
        return stringList.stream()
                .filter(word -> word.chars().allMatch(c -> lettersStr.contains(Character.toString(c))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //7.
    public static List<String> findConvertIntToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //8.
    public static List<String> findPalindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(Main::isaPalindromeNumber)
                .mapToObj(String::valueOf)
                .toList();
    }

    private static boolean isaPalindromeNumber(int num) {
        var string = new StringBuilder(String.valueOf(num)).reverse().toString();
        return String.valueOf(num).equals(string);
    }

    //9.
    public static List<String> findPalindromeSubstrings(String string) {
        var words = string.split("\\W+");
        return Arrays.stream(words)
                .filter(Main::isaPalindromeWord)
                .toList();
    }

    private static boolean isaPalindromeWord(String word) {
        var string = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(string);
    }

    //10.
    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(Main::isaPerfectNumber)
                .boxed()
                .toList();
    }

    private static boolean isaPerfectNumber(int num) {
        return IntStream.rangeClosed(1, num / 2)
                .filter(d -> num % d == 0).sum() == num;
    }
}
