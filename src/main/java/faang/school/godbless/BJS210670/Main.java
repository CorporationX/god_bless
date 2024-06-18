package faang.school.godbless.BJS210670;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        List<String> binary = StreamApiMethods.convertToBinary(list);
        binary.forEach(System.out::println);


        List<Employee> employeeList = Arrays.asList(
                new Employee("Vika", 500d, "IT"),
                new Employee("Kostya", 400, "Finance"),
                new Employee("Timur", 1000d, "IT"),
                new Employee("Dima", 300d, "Finance")
        );

        Map<String, Double> result = StreamApiMethods.findAverageSalary(employeeList);
        result.entrySet().forEach((departament) -> System.out.println(departament.getKey() + " :" + departament.getValue()));

        Map<String, List<String>> mapFriends = new HashMap<>() {{
            put("Alice", Arrays.asList("Bob", "Charlie"));
            put("Bob", Arrays.asList("Alice", "David"));
            put("Charlie", Arrays.asList("Alice", "David"));
            put("David", Arrays.asList("Bob", "Charlie"));

        }};

        var commonFriends = StreamApiMethods.findCommonFriends(mapFriends);
        commonFriends.forEach(System.out::println);

        List<Integer> palindrom = StreamApiMethods.allPalindromes(10, 10000);
        palindrom.forEach(System.out::println);

        Map<String, String> mapCountries = new HashMap<>() {{
            put("Russia", "Moscow");
            put("Kazakhstan", "Astana");
            put("Armenia", "Yerevan");
            put("UK", "London");
        }};

        var sortedMap = StreamApiMethods.sortCountries(mapCountries);
        System.out.println("\nSORTED COUNTRIES:");
        sortedMap.forEach((country, city) -> System.out.println(country + " :" + city));

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> alphabetSet = StreamApiMethods.convertToChar(alphabet);

        List<String> lines = Arrays.asList(
                "apple",
                "banana",
                "cat",
                "123",
                "dog"
        );

        List<String> sortedLines = StreamApiMethods.sortLines(lines, alphabetSet);
        sortedLines.forEach(System.out::println);

        List<String> linesOfWords = List.of("Sugar", "blow", "start", "summa", "tank", "cat");
        System.out.println(StreamApiMethods.startsWithCharacter(linesOfWords, 's'));

        List<Integer> numbers = List.of(2, 3, 5, 7, 8, 10);
        var resultOfSums = StreamApiMethods.targetSum(numbers, 10);
        resultOfSums.forEach(System.out::println);
    }
}
