package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamProcess {
    public static List<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Set<List<Integer>> uniquePairs = new HashSet<>();

        for (int num : numbers) {
            int diff = targetSum - num;
            if (uniqueNumbers.contains(diff)) {
                List<Integer> pair = Arrays.asList(num, diff);
                Collections.sort(pair);
                uniquePairs.add(pair);
            }
        }
        return new ArrayList<>(uniquePairs);
    }

    public static List<String> sortCapitalByCountry(Map<String, String> capitals) {
        List<String> sortedCapitals = new ArrayList<>();

        capitals.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> sortedCapitals.add(entry.getValue()));
        return sortedCapitals;
    }

    public static List<String> filterAndSortStringsByChar(List<String> strings, char prefix) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(prefix)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findNonFriendPairs(Map<String, List<String>> friendships) {
        List<List<String>> nonFriendsPair = new ArrayList<>();

        Set<String> allPeople = friendships.keySet();
        for (String person1 : allPeople) {
            for (String person2 : allPeople) {
                if (!person1.equals(person2) && !friendships.get(person1).contains(person2)) {
                    List<String> pair = Arrays.asList(person1, person2);
                    Collections.sort(pair);
                    if (!nonFriendsPair.contains(pair)) {
                        nonFriendsPair.add(pair);
                    }
                }
            }
        }
        return nonFriendsPair;
    }

    public static Map<String, Double> calculateAverageWageByDepartment(List<Employee> employees) {
        Map<String, List<Double>> departmentWageMap = new HashMap<>();

        for(Employee employee : employees){
            String department = employee.getDepartment();
            double wage = employee.getWage();
            departmentWageMap.computeIfAbsent(department, k -> new ArrayList<>()).add(wage);
        }

        Map<String, Double> averageWageMap = new HashMap<>();
        for(Map.Entry<String,List<Double>> entry : departmentWageMap.entrySet()){
            String department = entry.getKey();
            List<Double> wages = entry.getValue();
            double averageWage = wages.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            averageWageMap.put(department, averageWage);
        }

        return averageWageMap;
    }

    public static List<String> filterAndSortAlphabeticStrings(List<String> strings, String alphabet){
        return strings.stream().filter(s-> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> convertToBinaryList(List<Integer> numbers){
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromeInRange(int start, int end){
        List<Integer> palindromes = new ArrayList<>();

        for(int num = start; num <= end; num++){
            if(isPalindrome(num))
            {
                palindromes.add(num);
            }
        }
        return palindromes;
    }

    private static boolean isPalindrome(int number) {
        int reversed = 0;
        int temp = number;

        while (temp != 0) {
            int remainder = temp % 10;
            reversed = reversed * 10 + remainder;
            temp /= 10;
        }

        return number == reversed;
    }

}
