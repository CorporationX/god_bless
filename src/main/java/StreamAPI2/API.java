package StreamAPI2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class API {
    public static void main(String[] args) {
// 1
        List<Integer> numbers = Arrays.asList(1, 9, 6, 4, 5, 3);
        Methods.sumPairs(numbers, 10).forEach(System.out::println);
// 2
        Map<String, String> country = Map.of("Netherlands", "Amsterdam", "Andorra", "Andorra la Vella",
                "Greece", "Athens", "Serbia", "Belgrade", "Germany", "Berlin");
        Methods.sortAndPrint(country).forEach(System.out::println);
// 3
        List<String> words1 = Arrays.asList("Netherlands", "Andorra", "Greece", "Serbia", "Germany", "Berlin");
        Methods.filterAndSort(words1, 'G').forEach(System.out::println);
// 4
        Map<String, List<String>> friends = Map.of("Bob", Arrays.asList("Tom", "Rob"), "Rob", Arrays.asList("Alice", "Fill", "Bob"),
                "Fill", Arrays.asList("Alice", "Martin", "Rob"), "Alice", Arrays.asList("Rob", "Fill"));
        // (Bob - Alice, Fill)
        // (Rob - Tom, Martin)
        // (Fill - Bob)
        // (Alice - Martin, Bob)
//        Methods.findCommonFriends(friends).forEach(System.out::println);
// 5
        List<Employee> employees = Arrays.asList(new Employee("Bob", "office", 80000), new Employee("Rob", "home", 76000),
                new Employee("Martin", "office", 120000), new Employee("Fill", "home", 40000),
                new Employee("Misha", "office", 60000));
        Methods.averageSalary(employees).entrySet().forEach(System.out::println);
// 6
        List<String> words2 = Arrays.asList("cat", "apple", "dog", "123", "banana", "fds4");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Methods.sortAlphabet(words2, alphabet).forEach(System.out::println);
// 7
        Methods.binarTransformer(numbers).forEach(System.out::println);
// 8
        Methods.findPalindromes(1, 100).forEach(System.out::println);
    }
}
