package streamapi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===Test findAllUniqPairsWhichSumEqualsTargetNumber===");
        List<Integer> nums = List.of(1,9,3,6,4,5);
        System.out.println(findAllUniqPairsWhichSumEqualsTargetNumber(nums, 10));

        System.out.println("\n===Test printNameOfCapitalByAlphabet===");
        Map<String, String> map = Map.of("Russia", "Moscow", "USA", "Washington", "Italy", "Roma", "Spain", "Barcelona");
        printNameOfCapitalByAlphabet(map);

        System.out.println("\n===Test filterBySymbolAndSortByLength===");
        List<String> strings = List.of("Moscow", "Mom", "Dad", "Nick", "Chair", "Milkshake");
        filterBySymbolAndSortByLength(strings).forEach(System.out::println);

        System.out.println("\n===Test filterBySymbolAndSortByLength===");
        Map<String, List<String>> peoples = Map.of("Nick", List.of("Paul"),
                "Vadim", List.of("Paul"),
                "Anya", List.of("Nick", "Paul"));
        System.out.println(findPairsWhichNotFriendsButTheyHaveMutualFriends(peoples));

        System.out.println("\n===Test sumAvgSalaryByDepartment===");
        Employee employee1 = new Employee("Nick", 100000, "IT");
        Employee employee2 = new Employee("Nick", 200000, "IT");
        Employee employee3 = new Employee("Nick", 10000, "Dev");
        Employee employee4 = new Employee("Nick", 200000, "Dev");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4);
        sumAvgSalaryByDepartment(employees).forEach((dep, avgSal) -> System.out.println(String.format("Department: %s\nAvgSalary: %f", dep, avgSal)));

        System.out.println("\n===Test filterBySymbolAndSortByLength===");
        strings = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterByAlphabetAndSortByLength(strings, alphabet));

        System.out.println("\n===Test ListIntToListBinaryNums===");
        nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println(mapListIntToListBinaryNums(nums));

        System.out.println("\n===Test getAllPalindromesInRange===");
        System.out.println(getAllPalindromesInRange(1, 300));


        System.out.println("\n===Test getAllPalindromesInString===");
        String s = "mom dad java code level get all car nun";
        System.out.println(getAllPalindromesInString(s));

        System.out.println("\n===Test getAllPerfectNumbersInRange===");

        System.out.println(getAllPerfectNumbersInRange(1, 10000));

    }

    static Set<List<Integer>> findAllUniqPairsWhichSumEqualsTargetNumber(List<Integer> nums, int targetSum) {
        Set<List<Integer>> pairs = new HashSet<>();
        IntStream.range(0, nums.size())
                .forEach(i -> IntStream.range(i+1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == targetSum)
                        .forEach(j -> pairs.add(
                                List.of(
                                        Math.max(nums.get(i), nums.get(j)),
                                        Math.min(nums.get(i), nums.get(j))
                                )
                        ))
                );
        return pairs;
    }
    static void printNameOfCapitalByAlphabet(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().charAt(0)))
                .forEach(country -> System.out.println(country.getValue()));
    }

    static List<String> filterBySymbolAndSortByLength(List<String> strings) {
        return strings.stream()
                .filter(string -> string.charAt(0) == 'M')
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    static Set<List<String>> findPairsWhichNotFriendsButTheyHaveMutualFriends(Map<String, List<String>> people){
        Set<List<String>> pairs = new HashSet<>();
        people.forEach((k, v) -> people.entrySet().stream()
                .filter(entry -> !k.equals(entry.getKey()))
                .filter(entry -> !people.get(k).contains(entry.getKey()))
                .filter(entry  -> !people.get(entry.getKey()).contains(k))
                .forEach(entry -> {
                    if (k.compareTo(entry.getKey()) > 0) {
                        pairs.add(List.of(k, entry.getKey()));
                    } else {
                        pairs.add(List.of(entry.getKey(), k));
                    }
                }));
        return pairs;
    }

    static Map<String, Double> sumAvgSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> Arrays.stream(str.split("")).allMatch(alphabet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    static List<String> mapListIntToListBinaryNums(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    static List<Integer> getAllPalindromesInRange(int lowBorder, int highBorder) {
        return IntStream.range(lowBorder, highBorder + 1)
                .mapToObj(Integer::toString)
                .filter(Main::checkPalindrome)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    static List<String> getAllPalindromesInString(String string) {
        return Arrays.stream(string.split(" "))
                .filter(Main::checkPalindrome)
                .toList();
    }

    static List<Integer> getAllPerfectNumbersInRange(int lowBorder, int highBorder) {
        return IntStream.range(lowBorder, highBorder + 1)
                .filter(num -> num > 5)
                .filter(num -> num % 2 == 0)
                .filter(num -> {
                    int sumDiv = 0;
                    for (int i = 1; i < num; i++) {
                        if (num % i == 0) sumDiv += i;
                    }
                    return sumDiv == num;
                })
                .boxed()
                .toList();


    }

    static boolean checkPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }


}
