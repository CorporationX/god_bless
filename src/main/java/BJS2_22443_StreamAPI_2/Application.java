package BJS2_22443_StreamAPI_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 9, 3, 6, 4, 5, 2, 7);
        List<String> strings = Arrays.asList("Go go", "Tey ho", "Iwannagogozz", "whatisthisomg", "123");
        List<Employee> employees = Arrays.asList(new Employee("Egor", 500.0, "Sales"),
                new Employee("Misha", 700.0, "Sales"),
                new Employee("Lena", 800.0, "HR"),
                new Employee("Alex", 750.0, "HR"));

        char[] alphabet = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'
        };

        Map<String, String> countriesMap = new HashMap<>();
        countriesMap.put("ABC", "Moscow");
        countriesMap.put("XXX", "London");
        countriesMap.put("KLM", "Washington");
        countriesMap.put("HIJ", "Tokyo");

        char character = 'G';
        int start = 100;
        int end = 1000;
        int target = 10;

        //1
        System.out.println(findPairsBySum(nums, target));
        //2
        System.out.println(countries(countriesMap));
        //3
        System.out.println(sortStringsByLength(strings, character));
        //4
        //todo
        System.out.println(findPairsByMutualFriends(new HashMap<>()));
        //5
        System.out.println(departmentAverageSalary(employees));
        //6
        System.out.println(returnStrings(strings, alphabet));
        // 7
        System.out.println(toBinaryString(nums));
        // 8
        System.out.println(getAllPalindromeNumbers(start, end));

    }

    public static List<List<Integer>> findPairsBySum(List<Integer> nums, int target) {
        return IntStream.range(0, nums.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == target)
                        .mapToObj(j -> Arrays.asList(nums.get(i), nums.get(j)))
                )
                .collect(Collectors.toList());
    }

    // 2
    public static List<String> countries(Map<String, String> countriesCapitals) {
        List<String> capitals = new ArrayList<>();
        countriesCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> capitals.add(x.getValue()));
        return capitals;
    }

    // 3
    public static List<String> sortStringsByLength(List<String> strings, char startChar) {
        return strings.stream()
                .filter(x -> x.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 4
    public static Map<String, String> findPairsByMutualFriends(Map<String, List<String>> friends) {
        return new HashMap<>();
    }

    // 5
    public static Map<String, Double> departmentAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    // 6
    public static List<String> returnStrings(List<String> strings, char[] alphabet) {
        String alphabetString = new String(alphabet);
        return strings.stream()
                .filter(x -> x.toLowerCase().matches(String.format("[%s]+", alphabetString)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // 7
    public static List<String> toBinaryString(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //8 сюда на!
    public static List<Integer> getAllPalindromeNumbers(int startRange, int endRange) {
        return IntStream.rangeClosed(startRange, endRange)
                .filter(x -> String.valueOf(x).contentEquals(new StringBuilder().append(x).reverse()))
                .boxed()
                .toList();
    }
}
