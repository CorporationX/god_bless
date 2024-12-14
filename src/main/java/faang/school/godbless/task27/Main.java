package faang.school.godbless.task27;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int target = 10;

        Set<List<Integer>> pairs = findPairs(nums, target);
        System.out.println(pairs);
        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("France", "Paris");
        countryCapitals.put("Germany", "Berlin");
        countryCapitals.put("Italy", "Pome");
        countryCapitals.put("Spain", "Madrid");
        countryCapitals.put("Japan", "Tokyo");
        sortCountriesAndPrintCapitals(countryCapitals);

        System.out.println(sortCountriesAndPrintCapitals(countryCapitals.values().stream().toList(),'P'));

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        friendsMap.put("Bob", Arrays.asList("Alice", "Charlie"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "Bob", "David"));
        friendsMap.put("David", Arrays.asList("Alice", "Charlie"));
        friendsMap.put("Eve", List.of("Frank"));
        friendsMap.put("Frank", List.of("Eve"));
        System.out.println(findSubFriends(friendsMap));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "Engineering"),
                new Employee("Charlie", 55000, "HR"),
                new Employee("David", 70000, "Engineering"),
                new Employee("Eve", 65000, "Marketing")
        );
        System.out.println(getDistrictAvgSalary(employees));

        List<String> strings = Arrays.asList("abc", "def", "ghi", "jklm", "nopq", "1");
        String  alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(containsOnlyAlphabet(strings,alphabet));

        List<Integer> numbers = List.of(5, 10, 15, 20);
        List<String> binaryStrings = convertToBinaryStrings(numbers);
        System.out.println(binaryStrings);

        int start = 100;
        int end = 200;
        List<Integer> palindromicNumbers = findPalindromicNumbers(start, end);
        System.out.println(palindromicNumbers);

    }
    public static Set<List<Integer>> findPairs(List<Integer> integerList, int key) {
        return integerList.stream().flatMap(x -> integerList.stream().filter((y) -> x + y == key)
                .map(y -> Arrays.stream(new Integer[]{y,x}).sorted().toList()
                )).collect(Collectors.toSet());
    }
    public static void sortCountriesAndPrintCapitals(Map<String,String> countries) {
            countries.entrySet().stream().sorted((x,y)->y.getValue().compareTo(x.getValue())).map(Map.Entry::getValue).forEach(System.out::println);
    }
    public static List<String> sortCountriesAndPrintCapitals(List<String> strings, char letter) {
       return strings.stream().filter(s->s.startsWith(String.valueOf(letter))).sorted(Comparator.comparingInt(String::length)).toList();
    }
    public static List<List<String>> findSubFriends(Map<String,List<String>> friendsList) {
       return friendsList.entrySet().stream().flatMap(x->friendsList.entrySet().stream()
               .filter(v->!v.getValue().contains(x.getKey())&&v.getValue().stream().anyMatch(y->x.getValue().contains(y)))
                       .filter(y->x!=y)
               .map(y-> Stream.of(x.getKey(),y.getKey()).sorted().toList())).distinct()
               .toList();
    }
    public static Map<String,Integer> getDistrictAvgSalary(List<Employee> employees){
      return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
    }
    private static List<String> containsOnlyAlphabet(List<String> strings, String alphabet) {
       return  strings.stream()
                .filter(s -> s.chars()
                        .allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromicNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(x->new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x)))
                .boxed()
                .collect(Collectors.toList());
    }
}










