package faang.school.godbless.StreamAPI_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StaticClassStreamAPI {
    public static void main(String[] args) {
        System.out.println(sortedMapCountries(Map.of(
                "Russia", "Moscow",
                "China", "Beijing",
                "Austria", "Vien",
                "Bulgaria", "Sofia")));

        System.out.println(getFilterStringsAlphabet(List.of(
                "abc", "abcc123ba", "ac", "123", "acccaaa", "asasfe"), new char[]{'a', 'c'}));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(mapIntegerToString(numbers));

        int[] palindromes = getPalindromNumbers(10, 200);
        for (int num : palindromes) {
            System.out.println(num);
        }

        numbers = List.of(1, 7, 9, 3, 6, 4, 5, 3, 7);
        int targetSum = 13;
        getUniqPairNumbers(numbers, targetSum).forEach(num -> System.out.println(num));
    }

    public static List<List<Integer>> getUniqPairNumbers(List<Integer> nums, int a) {
        return nums.stream()
                .flatMap(firstNum -> nums.stream()
                .filter(secondNum -> (secondNum + firstNum) == a)
                .filter(secondNum -> secondNum < firstNum)
                .map(secondNum -> List.of(secondNum, firstNum)))
                .distinct()
                .toList();
    }

    public static List<String> sortedMapCountries(Map<String, String> countryCapital) {
        return countryCapital.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> getSortedStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(letter + ""))
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static Map<String, Double> getMapAvengerSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getFilterStringsAlphabet(List<String> words, char[] letters) {
        Set<Character> lettersSet = IntStream.range(0, letters.length)
                .mapToObj(chr -> letters[chr])
                .collect(Collectors.toSet());

        return words.stream()
                .filter(word -> word.chars()
                .allMatch(letter -> lettersSet.contains((char) letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> mapIntegerToString(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static int[] getPalindromNumbers(int first, int second) {
        return IntStream.rangeClosed(first, second)
                .filter(num -> Integer.toString(num)
                .equals(new StringBuilder(Integer.toString(num)).reverse().toString())).toArray();
    }
}
