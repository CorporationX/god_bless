package faang.school.godbless.BJS2_22500;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static List<List<Integer>> findUniquePairsSumIsEqualTarget(List<Integer> nums, int target) {
        return nums.stream()
                .flatMap(i ->
                    nums.stream()
                            .filter(j -> i + j == target)
                            .filter(j -> !i.equals(j))
                            .map(j -> Stream.of(i, j).sorted().toList())
                )
                .distinct()
                .toList();
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
                        .filter(entry -> !entry.getValue().contains(person.getKey()))
                        .filter(entry -> !entry.getKey().equals(person.getKey()))
                        .filter(entry -> entry.getValue()
                                .stream()
                                .anyMatch(friend -> person.getValue().contains(friend)))
                        .map(entry -> Stream.of(person.getKey(), entry.getKey()).sorted().toList())
                )
                .distinct()
                .toList();
    }

    public static Map<String, Double> getMapDepartmentByAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, char[] alphabet) {
        Set<Character> chars = charArrayToSet(alphabet);
        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(symbol -> chars.contains((char) symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static Set<Character> charArrayToSet(char[] array) {
        return IntStream.range(0, array.length)
                .mapToObj(i -> array[i])
                .collect(Collectors.toSet());
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
                .filter(num -> num == IntStream.range(1, num)
                        .filter(divisor -> num % divisor == 0)
                        .sum()
                ).toArray();
    }
}
