package stream.training2;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(getNumberPairs(List.of(1, 9, 3, 6, 4, 5), 10));
        System.out.println(getSortedCapitals(Map.of(
                "Russia", "Moscow",
                "China", "Beijing",
                "Austria", "Vien",
                "Bulgaria", "Sofia")));
        System.out.println(getSortedStringsStartedWithLetter(List.of("abababab", "abab", "ab", "abccc", "bcbc", "edfdd"), 'a'));
        System.out.println(getPeoplePairsWithSameFriends(Map.of(
                "Petya", List.of("Vasya", "Vanya"),
                "Vasya", List.of("Petya", "Kolya"),
                "Vanya", List.of("Petya"),
                "Kolya", List.of("Vasya"))));
        System.out.println(getSortedStringWithLetterInAlphabet(List.of(
                "abc", "abccba", "ab", "c", "defaef", "asasfe"), new Character[]{'a', 'b', 'c'}));
        System.out.println(getAverageSalaryForDepartment(List.of(
                new Employee("Vanya", "IT", 2300),
                new Employee("Vasya", "HR", 1700),
                new Employee("Petya", "IT", 3000),
                new Employee("Katya", "HR", 2000))));
        System.out.println(getBinaryStringOfNumber(List.of(1, 2, 3, 4, 5, 18, 22, 56)));
        System.out.println(getAllNumberPalindromes(100, 300));
        System.out.println(getAllPalindromicSubstrings("abcbef"));
        System.out.println(getAllPerfectNumbers(1, 10000));
    }

    public static List<List<Integer>> getNumberPairs(@NonNull List<Integer> numbers, int targetSum) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .mapToObj(j -> List.of(numbers.get(i), numbers.get(j))))
                .filter(pair -> pair.get(0) + pair.get(1) == targetSum)
                .collect(Collectors.toList());
    }

    public static String getSortedCapitals(@NonNull Map<String, String> countriesCapitals) {
        return countriesCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(", "));
    }

    public static List<String> getSortedStringsStartedWithLetter(@NonNull List<String> lines, char letter) {
        return lines.stream()
                .filter(line -> line.startsWith(Character.toString(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getPeoplePairsWithSameFriends(@NonNull Map<String, @NonNull List<String>> peopleFriends) {
        List<String> peoples = peopleFriends.keySet().stream().toList();
        return IntStream.range(0, peoples.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, peoples.size())
                        .mapToObj(j -> List.of(peoples.get(i), peoples.get(j))))
                .filter(pair -> !peopleFriends.get(pair.get(0)).contains(pair.get(1)))
                .filter(pair -> {
                    for (String friend : peopleFriends.get(pair.get(0))) {
                        if (peopleFriends.get(pair.get(1)).contains(friend)) {
                            return true;
                        }
                    }
                    return false;
                })
                .toList();
    }

    public static List<String> getSortedStringWithLetterInAlphabet(@NonNull List<String> lines, @NonNull Character[] alphabet) {
        return lines.stream()
                .filter(line -> new HashSet<>(Arrays.stream(alphabet)
                        .map(c -> Character.toString(c))
                        .toList()).containsAll(Arrays.asList(line.split(""))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Map<String, Double> getAverageSalaryForDepartment(@NonNull List<Employee> employees) {
        var departments = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return departments.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(Employee::getSalary)
                                .mapToDouble(Double::doubleValue)
                                .average().orElseThrow()));
    }

    public static List<String> getBinaryStringOfNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getAllNumberPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(n -> isPalindrome(n.toString()))
                .toList();
    }

    public static List<String> getAllPalindromicSubstrings(@NonNull String line) {
        return IntStream.range(0, line.length() + 1)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, line.length() + 1)
                        .mapToObj(j -> line.substring(i, j)))
                .filter(Main::isPalindrome)
                .distinct()
                .toList();
    }

    public static List<Integer> getAllPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(Main::isPerfectNumber)
                .toList();
    }

    private static boolean isPalindrome(@NonNull String line) {
        for (int i = 0; i < line.length() / 2; i++) {
            if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
