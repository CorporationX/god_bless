package faang.school.godbless.stream_split.stream_api_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static Set<Pair<Integer>> uniquePair(List<Integer> nums, int target) {

        return nums.stream().filter(n -> nums.stream()
                        .anyMatch(num -> (n + num == target && !n.equals(num))))
                .map(n -> new Pair<>(n, target - n).sort())
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountry(Map<String, String> country) {

        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> sortStrings(List<String> srs, char letter) {
        return srs.stream().filter(s -> s.charAt(0) == letter).sorted().toList();
    }

    public static Set<Pair<String>> getListFriend(Map<String, List<String>> users) {
        return users.entrySet().stream()
                .flatMap(mainUser -> removeUnsuitableFriends(users, mainUser)).collect(Collectors.toSet());
    }

    public static Stream<Pair<String>> removeUnsuitableFriends(Map<String, List<String>> users, Map.Entry<String, List<String>> mainUser) {

        return users.entrySet().stream()
                .filter(u -> !u.equals(mainUser))
                .filter(u -> !mainUser.getValue().contains(u.getKey()))
                .filter(u -> {
                    Set<String> set = new HashSet<>(u.getValue());
                    set.retainAll(mainUser.getValue());
                    return !set.isEmpty();
                }).map(u -> new Pair<>(mainUser.getKey(), u.getKey()).sort());
    }

    public static Map<String, Float> averageSalaryDep(List<Employee> workers) {
        Map<String, Float> averageSal = new HashMap<>();

        workers.stream()
                .map(Employee::department).distinct()
                .forEach(worker -> calcAverageSalary(workers, worker, averageSal));

        return averageSal;
    }

    public static void calcAverageSalary(List<Employee> workers, String worker, Map<String, Float> averageSal) {
        long count = workers.stream()
                .filter(w -> w.department().equals(worker)).count();

        float sum = workers.stream()
                .filter(w -> w.department().equals(worker))
                .map(Employee::salary).reduce(0, Integer::sum);

        averageSal.put(worker, sum / count);
    }

    public static List<String> alphabetSorting(List<String> stgs, List<Character> alphabet) {

        return stgs.stream()
                .filter(s -> alphabet.containsAll(s.chars().mapToObj(c -> (char) c)
                        .toList()))
                .toList();
    }

    public static List<String> translateIntToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> palindrome(int start, int end) {
        IntStream range = IntStream.range(start, end);

        return range.boxed().filter(Main::checkPalindrome).toList();
    }

    public static Boolean checkPalindrome(Integer n) {
        String st = String.valueOf(n);
        StringBuffer reverse = new StringBuffer(st).reverse();
        return reverse.toString().equals(st);
    }


    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 9, 3, 6, 4, 5);
        System.out.println(uniquePair(nums, 10)); // (1,9) (4,6)

        Map<String, String> countries = Map.of("Russia", "Moscow", "Kazakstan", "Astana", "Japan", "Tokio");

        System.out.println(sortCountry(countries));

        List<String> srs = List.of("gad", "dslf", "a", "afdgl", "dsf", "ad");

        System.out.println(sortStrings(srs, 'a'));

        Map<String, List<String>> userToFriendsMap = Map.of(
                "User 1", List.of(),
                "User 2", List.of("User 3"),
                "User 3", List.of("User 2", "User 4", "User 5"),
                "User 4", List.of("User 3", "User 5"),
                "User 5", List.of("User 3", "User 4"));

        System.out.println(getListFriend(userToFriendsMap));

        List<Employee> employees = List.of(new Employee("John", 10, "A"),
                new Employee("Ann", 3, "B"),
                new Employee("Nik", 7, "A"),
                new Employee("Max", 9, "B"),
                new Employee("Max", 20, "IT"));

        System.out.println(averageSalaryDep(employees));

        List<String> strings = List.of("apple", "banana", "123", "dog", "cat", "@df");
        List<Character> al = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        System.out.println(alphabetSorting(strings, al));

        System.out.println(translateIntToBinary(nums));

        System.out.println(palindrome(0, 102));
    }
}