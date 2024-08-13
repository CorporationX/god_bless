package faang.school.godbless.modul2.streamapi2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //1. Find all the unique pairs of numbers whose sum is equal to the specified number.
        System.out.println("1. Find unique pairs of numbers:");
        List<Integer> numsList = List.of(1, 9, 3, 6, 4, 5);
        getUniquePairs(numsList, 10);

        //2. Sort the countries alphabetically, and then display the names of their capitals as a list.
        Map<String, String> countryMap = Map.of("Russia", "Moscow ", "Belarus", "Minsk", "Kazakhstan", "Astana");
        System.out.println("\n" + "2. Display capitals sort by countries name:");
        sortCountryMap(countryMap);

        //3. Filter the lines that start with the given letter and sort them by length in ascending order, and return a list of these lines.
        List<String> stringList = List.of("SUPER", "DISCO", "SWAG", "VIP", "DAB");
        System.out.println("\n" + "3. Filtered strings sorted by their length:");
        filterStringList(stringList, 'S');
        filterStringList(stringList, 'D');

        //4. Find all pairs of people who are not friends, but they have mutual friends.
        Map<String, List<String>> friends = getFriendsMap();
        System.out.println("\n" + "4. Find pairs people with joint friends:");
        findPairsWithJointFriends(friends);

        //5. Find the average salary for each department.
        List<Employee> employees = getEmployees();
        System.out.println("\n" + "5. Find department average salary:");
        findDepartmentAverageSalary(employees);

        //6. Filter the strings that contain only the letters of the specified alphabet and sort them in ascending order of the length of the strings.
        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println("\n" + "6. Filter strings and sort:");
        filterAndSortString(strings, alphabet);

        //7. Converts a list of integers into a list of strings, where each number is written in binary form.
        List<Integer> integerList = List.of(10, 110, 220, 103, 1);
        System.out.println("\n" + "7. Convert integers to binary:");
        convertIntToBinary(integerList);

        //8. Find all palindrome numbers from diapason.
        int a = 10;
        int b = 200;
        System.out.println("\n" + "8. Palindrome numbers from " + a + " to " + b + ":");
        findPalindromeNumbers(a, b);

        //9. Find all palindrome substring in sentence.
        String palindromeSentence = "Madam, Anna and Bob went to the park.";
        System.out.println("\n" + "9. Palindrome substring:");
        findPalindromeSubstrings(palindromeSentence);

        //10. Find all Perfect numbers from diapason.
        int x = 1;
        int y = 1000;
        System.out.println("\n" + "10. Perfect numbers from " + x + " to " + y + ":");
        findPerfectNumbers(x, y);
    }

    //1.
    public static void getUniquePairs(List<Integer> numsList, Integer num) {
        numsList.stream()
                .flatMap(i -> numsList.stream()
                        .filter(j -> !i.equals(j) && i < j && i + j == num)
                        .map(j -> i + " + " + j + " = " + num))
                .distinct()
                .forEach(System.out::println);
    }

    //2.
    public static void sortCountryMap(Map<String, String> stringMap) {
        stringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    //3.
    private static void filterStringList(List<String> stringList, char letter) {
        stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    //4.
    public static void findPairsWithJointFriends(Map<String, List<String>> friends) {
        friends.forEach((key, value) -> friends.forEach((key2, value2) -> {
            if (!key.equals(key2) && !value.contains(key2) && value2.stream().anyMatch(value::contains) && key.compareTo(key2) < 0) {
                System.out.println(key + " <--> " + key2);
            }
        }));

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
    public static void findDepartmentAverageSalary(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .forEach((department, avrSalary) ->
                        System.out.println(department + ": " + avrSalary));
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
    public static void filterAndSortString(List<String> stringList, char[] letters) {
        var lettersStr = new String(letters);
        stringList.stream()
                .filter(word -> word.chars().allMatch(c -> lettersStr.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    //7.
    public static void convertIntToBinary(List<Integer> integers) {
        integers.forEach(i -> System.out.println(i + " = " + Integer.toBinaryString(i)));
    }

    //8.
    public static void findPalindromeNumbers(int start, int end) {
        IntStream.range(start, end)
                .filter(num -> String.valueOf(num).equals(new StringBuilder(String.valueOf(num)).reverse().toString()))
                .forEach(System.out::println);
    }

    //9.
    public static void findPalindromeSubstrings(String string) {
        var words = string.split("\\W+");
        Arrays.stream(words)
                .filter(word -> word.equalsIgnoreCase(new StringBuilder(word).reverse().toString()))
                .forEach(System.out::println);
    }

    //10.
    public static void findPerfectNumbers(int start, int end) {
        IntStream.range(start, end)
                .filter(num -> IntStream.rangeClosed(1, num / 2).filter(d -> num % d == 0).sum() == num)
                .forEach(System.out::println);
    }
}
