package faang.school.godbless.module.second.stream.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //1-e задание
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int targetSum = 10;
        System.out.println(findUniquePairsWithSum(integers, targetSum));
        //2-e задание
        Map<String, String> countryStolica = Map.of(
            "Russia", "Moscow",
            "Armenia", "Yerevan",
            "Belarus", "Minsk",
            "Burkina-Faso", "Uagadugu"
            );
        sortCountries(countryStolica);
        //3-e задание
        List<String> strings = List.of("Koka", "Cola", "Kernel", "Booba", "Cooba");
        char startsWith = 'K';
        System.out.println(filterStringsSortedByLength(strings, startsWith));
        //4-e задание
        Map<String, List<String>> friends = Map.of(
            "Vova", List.of("Dima", "Egor", "Nastya"),
            "Liza", List.of("Ula","Nastya"),
            "Gosha", List.of("Egor")
        );
        System.out.println(findFriends(friends));
        //5-e задание
        List<Employee> employees = List.of(
            new Employee("Vova", 100, "Prodaja"),
            new Employee("Dima", 200, "Prodaja"),
            new Employee("Kirill", 100, "Hleb")
        );
        System.out.println(findAverageSalaryByOtdel(employees));
        //6-e задание
        String[] alphabet = { "K", "o", "k", "a" };
        System.out.println(getStringsOnlyInAlphabet(strings, alphabet));
        //7-e задание
        System.out.println(convertIntegerListToBinaryStringList(integers));
        //8-e задание
        System.out.println(getPalindromeNumbers(4, 80));
        //9-e задание
        String palindromString = "pallapfroorfaao";
        System.out.println(findSubstingPalindroms(palindromString));
        //10-e задание
        System.out.println(getPerfectNumbers(1, 120));
    }
    
    private static Set<String> findSubstingPalindroms(String string) {
        Set<String> palindromes = new HashSet<>();
        IntStream.range(0, string.length())
            .forEach(outerIndex -> IntStream.range(0, string.length())
                .filter(innerIndex -> outerIndex + innerIndex <= string.length())
                .mapToObj(innerIndex -> string.substring(outerIndex, outerIndex + innerIndex))
                .filter(substring -> substring.length() > 1 && !substring.isBlank())
                .filter(substring -> new StringBuilder(substring).reverse().toString().equals(substring))
                .forEach(substring -> palindromes.add(substring)));
        return palindromes;
    }
    
    private static List<String> getStringsOnlyInAlphabet(List<String> strings, String[] alphabet) {
        List<String> alphabetList = Arrays.asList(alphabet);
        return strings.stream()
            .filter(word -> Arrays.stream(word.split("")).allMatch(letter -> alphabetList.contains(letter)))
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }
    
    private static Map<String, Double> findAverageSalaryByOtdel(List<Employee> employees) {
        return employees.stream()
            .collect(Collectors.groupingBy(Employee::getOtdel, Collectors.averagingDouble(Employee::getSalary)));
    }
    
    private static Map<String, String> findFriends(Map<String, List<String>> friends) {
        Map<String, String> notFriends = new HashMap<>();
        friends.entrySet().stream().forEach(outerEntry -> {
            friends.entrySet().stream().forEach(innerEntry -> {
                if (outerEntry.equals(innerEntry)) {
                    return;
                }
                if (!Collections.disjoint(outerEntry.getValue(), innerEntry.getValue())) {
                    notFriends.putIfAbsent(outerEntry.getKey(), innerEntry.getKey());
                }
            });
        });
        
        return notFriends;
    }
    
    private static List<String> filterStringsSortedByLength(List<String> strings, char startsWith) {
        return strings.stream()
            .filter((string) -> string.charAt(0) == startsWith)
            .sorted(Comparator.comparing(String::length))
            .toList();
    }
    
    private static void sortCountries(Map<String, String> countries) {
        List<String> collect = countries.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .map((entry -> entry.getValue()))
            .collect(Collectors.toList());
        System.out.println(collect);
    }
    
    private static Set<List<Integer>> findUniquePairsWithSum(List<Integer> nums, int targetSum) {
        Set<List<Integer>> pairs = new HashSet<>();
        IntStream.range(0, nums.size())
            .forEach(i -> IntStream.range(i, nums.size())
                .filter(j -> i != j && nums.get(i) + nums.get(j) == targetSum)
                .forEach(j -> pairs.add(List.of(nums.get(i), nums.get(j)))));
        return pairs;
    }
    
    private static List<String> convertIntegerListToBinaryStringList(List<Integer> nums) {
        return nums.stream().map(number -> Integer.toBinaryString(number)).toList();
    }
    
    private static List<Integer> getPalindromeNumbers(int start, int finish) {
        return IntStream.range(start, finish)
            .filter(number -> {
                String str = String.valueOf(number);
                return new StringBuilder(str).reverse().toString().equals(str);
            })
            .boxed()
            .collect(Collectors.toList());
    }
    
    private static List<Integer> getPerfectNumbers(int start, int finish) {
        return IntStream.range(start, finish)
            .filter(number -> IntStream.range(1, number).filter(delitel -> number % delitel == 0).sum() == number)
            .boxed()
            .toList();
    }
}
