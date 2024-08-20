package faang.school.godbless.BJS2_22500;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static Set<List<Integer>> findUniquePairsSumIsEqualTarget(List<Integer> nums, int target) {
        return nums.stream()
                .flatMap(i ->
                    nums.stream()
                            .filter(j -> i + j == target && !i.equals(j))
                            .map(j -> {
                                List<Integer> pair = new ArrayList<>(List.of(i, j));
                                Collections.sort(pair);
                                return pair;
                            })
                )
                .collect(Collectors.toSet());
    }

    public static void sortAndPrintCapitals(Map<String, String> countryByCapital) {
        countryByCapital.keySet().stream()
                .sorted()
                .forEach(key -> System.out.println(countryByCapital.get(key)));
    }

    public static List<String> sortByLengthWithFilterByTarget(List<String> strings, char target) {
        return strings.stream()
                .filter(string -> string.charAt(0) == target)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findPairsWhoNotFriendsButHaveMutualFriends(Map<String, List<String>> nameByNamesFriends) {
        return nameByNamesFriends.entrySet().stream()
                .flatMap(person -> nameByNamesFriends.entrySet().stream()
                        .filter(isValidFriend(person))
                        .map(entry -> {
                            List<String> pair = new ArrayList<>(List.of(person.getKey(), entry.getKey()));
                            Collections.sort(pair);
                            return pair;
                        })
                )
                .distinct()
                .toList();
    }

    private static Predicate<Map.Entry<String, List<String>>> isValidFriend(Map.Entry<String, List<String>> person) {
        return entry -> !entry.getValue().contains(person.getKey()) &&
                !entry.getKey().equals(person.getKey()) &&
                entry.getValue()
                        .stream()
                        .anyMatch(friend -> person.getValue().contains(friend));
    }

    public static Map<String, Double> getMapDepartmentByAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, char[] alphabet) {
        Set<Character> chars = charArrayToSet(alphabet);
        return strings.stream()
                .filter(isValidString(chars))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static Set<Character> charArrayToSet(char[] array) {
        return IntStream.range(0, array.length)
                .mapToObj(i -> array[i])
                .collect(Collectors.toSet());
    }

    private static Predicate<String> isValidString(Set<Character> chars) {
        return string -> string.chars()
                .allMatch(symbol -> chars.contains((char) symbol));
    }

    public static List<String> numbersToBinaryNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static int[] findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(String::valueOf)
                .filter(isPalindrome())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<String> findPalindromesInRange(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i, string.length())
                                .mapToObj(j -> string.substring(i, j))
                )
                .filter(substring -> !substring.isEmpty())
                .filter(isPalindrome())
                .distinct()
                .toList();
    }

    private static Predicate<String> isPalindrome() {
        return string -> new StringBuilder(string).reverse().toString().equals(string);
    }

    public static int[] findPerfectNumbersInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(isPerfectNumber()).toArray();
    }

    private static IntPredicate isPerfectNumber() {
        return num -> num == IntStream.range(1, num)
                .filter(divisor -> num % divisor == 0)
                .sum();
    }
}
