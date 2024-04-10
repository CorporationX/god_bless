package faang.school.godbless.bjs2_5123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        //1.
        System.out.println("Find unique pairs of numbers:");
        List<Integer> numbers = List.of(3, 5, 2, 4, 1);
        findUniquePairs(numbers, 6);

        //2.
        Map<String, String> countryMap = Map.of("USA", "Washington", "Russia", "Moscow", "Germany", "Berlin");
        System.out.println("\nSorted capitals:");
        sortCountryMap(countryMap).forEach(System.out::println);

        //3.
        List<String> stringList = List.of("string 2 with", "string 1", "word which all knows", "super idea");
        System.out.println("\nFiltered strings sorted by their length");
        filterStringList(stringList, 's').forEach(System.out::println);

        //4.
        System.out.println("\nFind pairs people with mutual friends:");
        Map<String, List<String>> friends = new HashMap<>();
        String vasya = "Vasya";
        String misha = "Misha";
        String sveta = "Sveta";
        String dima = "Dima";
        friends.put(vasya, List.of(misha, sveta));
        friends.put(misha, List.of(vasya, dima));
        friends.put(sveta, List.of(vasya));
        friends.put(dima, List.of(misha));
        findPairsPeopleWithMutualFriends(friends);
        //dima - vasya
        //misha - sveta

        //5.
        System.out.println("\nFind average department salary");
        Employee scott = new Employee("Scott", 2000, "IT");
        Employee smith = new Employee("Smith", 2500, "IT");
        Employee pitt = new Employee("Pitt", 15500, "VIDEO");
        Employee madsen = new Employee("Madsen", 8000, "VIDEO");
        Employee mask = new Employee("Mask", 50000, "Management");
        Employee besos = new Employee("Besos", 52000, "Management");
        List<Employee> employees = List.of(scott, smith, pitt, madsen, mask, besos);
        Map<String, Double> averageDepartmentSalary = findAverageDepartmentSalary(employees);
        for (Map.Entry<String, Double> entry : averageDepartmentSalary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //6. Test example
        //Input Strings: [apple, banana, 123, dog, cat]
        //Alphabet: abcdefghijklmnopqrstuvwxyz
        //Output: [dog, cat, apple, banana]
        System.out.println("\nFilter strings and sort");
        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        String abc = "abcdefghijklmnopqrstuvwxyz";
        filterAndSortString(strings, abc).forEach(System.out::println);

        //7. Test
        System.out.println("\nConvert integers to binary");
        List<Integer> integers = List.of(10, 11, 12, 13, 14);
        System.out.println(convertIntegersToBinary(integers));
        //["1010", "1011", "1100", "1101", "1110"]

        //8. Test
        System.out.println("\nPalindrom numbers:");
        System.out.println(findPolindromeNumbers(10, 203));

        //9.
        System.out.println("\nPalindroms in string");
        String palindrom = "тут как тут";
        System.out.println(findPalindromeSubstrings(palindrom));

        //10.
        System.out.println("\nFind all perfect numbers in range");
        System.out.println(findPerfectNumbers(0, 1000));
        //[6, 28, 496]
    }

    //1.
    public static void findUniquePairs(List<Integer> numbers, Integer num) {
        IntStream.range(0, numbers.size())
                .forEach(i -> IntStream.range(0, numbers.size())
                        .filter(j -> i != j && numbers.get(i) + numbers.get(j) == num)
                        .forEach(j -> System.out.println(numbers.get(i) + " + " + numbers.get(j) + " = " + num))
                );

    }

    //2.
    public static List<String> sortCountryMap(Map<String, String> stringMap) {
        return stringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //3.
    public static List<String> filterStringList(List<String> stringList, char letter) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //4.
    public static void findPairsPeopleWithMutualFriends(Map<String, List<String>> friends) {
        friends.forEach((key, value) -> friends.entrySet().stream()
                .filter(entry2 -> !value.contains(entry2.getKey()) && !key.equals(entry2.getKey()))
                .forEach(entry2 -> entry2.getValue().stream()
                        .filter(value::contains)
                        .forEach(name -> System.out.println(key + " <--> " + entry2.getKey()))));

    }

    //5.
    public static Map<String, Double> findAverageDepartmentSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    //6.
    public static List<String> filterAndSortString(List<String> stringList, String letters) {
        List<String> abc = List.of(letters.split(""));
        return stringList.stream()
                .filter(word -> Arrays.stream(word.split(""))
                        .allMatch(abc::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //7.
    public static List<String> convertIntegersToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //8.
    public static List<String> findPolindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(String::valueOf)
                .filter(num -> new StringBuilder(num).reverse().toString().equals(num))
                .toList();
    }

    //9.
    public static List<String> findPalindromeSubstrings(String string) {
        List<String> result = new ArrayList<>();
        IntStream.range(0, string.length())
                .forEach(index -> IntStream.range(0, string.length())
                        .filter(i -> index + i <= string.length())
                        .mapToObj(i -> string.substring(index, index + i))
                        .filter(substring -> new StringBuilder(substring).reverse().toString().equals(substring))
                        .collect(Collectors.toCollection(() -> result)));
        return result;
    }

    //10.
    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(num -> IntStream.range(1, num).filter(d -> num % d == 0).sum() == num)
                .boxed().toList();
    }
}
