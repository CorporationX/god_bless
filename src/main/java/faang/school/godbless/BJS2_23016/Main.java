package faang.school.godbless.BJS2_23016;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Hello", "Bonjour", "Hi", "Cat", "Bingo", "Hurricane", "HelloWorld");
        System.out.println("sum of even numbers:");
        int sum = nums.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("Max element:");
        int max = nums.stream().max(Integer::compare).orElse(0);
        System.out.println(max);
        System.out.println("Avg value: ");
        double avgValue = (double) nums.stream().reduce(0, Integer::sum) / nums.size();
        System.out.println(avgValue);
        System.out.println("Count words starts with 'H':");
        long countWord = words.stream().filter(word -> word.startsWith("H")).count();
        System.out.println(countWord);
        System.out.println("Words contain 'ello':");
        List<String> filterList = words.stream().filter(word -> word.contains("ello")).toList();
        System.out.println(filterList);
        System.out.println("Sorted words:");
        List<String> sortedList = words.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(sortedList);
        System.out.println("Words length condition:");
        boolean lengthCondition = words.stream().allMatch(word -> word.length() > 1);
        System.out.println(lengthCondition);
        System.out.println("Min element that is greater than condition:");
        int condition = 4;
        int resultNem = nums.stream().filter(num -> num > condition).min(Integer::compare).orElse(Integer.MAX_VALUE);
        System.out.println(resultNem);
        System.out.println("List of strings to list of string lengths:");
        List<Integer> wordsLength = words.stream().map(String::length).toList();
        System.out.println(wordsLength);
    }
}
