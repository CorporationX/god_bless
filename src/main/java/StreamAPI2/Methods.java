package StreamAPI2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Methods {

    public static List<List<Integer>> sumPairs(List<Integer> numbers, int target) {
        Set<Integer> duplicate = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        numbers.forEach(number -> {
            int second = target - number;
            duplicate.add(number);
            if (numbers.contains(second) && !duplicate.contains(second)) {
                duplicate.add(second);
                pairs.add(List.of(number, second));
            }
        });
        return pairs;
    }

    public static List<String> sortAndPrint(Map<String, String> country) {
        return country.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                map(Map.Entry::getValue).toList();
    }

    public static List<String> filterAndSort(List<String> words, char symbol) {
        return words.stream().filter(word -> word.charAt(0) == symbol).sorted().toList();
    }

//    4
//    public static List<List<String>> findCommonFriends(Map<String, List<String>> friends) {
//
//    }

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> sortAlphabet(List<String> words, String alphabet) {
        Set<Character> alphabetChar = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return words.stream().filter(word -> word.chars().allMatch(c -> alphabetChar.contains((char) c)))
                .sorted().toList();
    }

    public static List<String> binarTransformer(List<Integer> number) {
        return number.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromes(int first, int second) {
        return IntStream.rangeClosed(first, second).
                mapToObj(String::valueOf).filter(x -> x.contentEquals(new StringBuilder(x).reverse()))
                .mapToInt(Integer::parseInt).boxed().toList();
    }
}
