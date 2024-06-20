package faang.school.godbless.sprint2.streamAPI2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,5,1,8);
        Integer targetNumber = 5;

        List<List<Integer>> uniquePairsOfSum = CalculateStreams.getUniquePairsOfSum(list, targetNumber);
        System.out.println("task 1, unique params: " + uniquePairsOfSum);

        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("belarus", "Minsk");

        List<String> cityList = CalculateStreams.getCityList(map);
        System.out.println("task 2, city list: " + cityList);

        List<String> sorteredElements = CalculateStreams.getListOfStringsStartsFromCharAndSortedByLength(cityList, "M");
        System.out.println("task 3, sortered Strings: " + sorteredElements);


        Map<String, List<String>> friends = new HashMap<>();
        friends.put("friend1", Arrays.asList("friend2", "friend3", "friend4"));
        friends.put("friend2", Arrays.asList("friend1", "friend3"));
        friends.put("friend3", Arrays.asList("friend1", "friend2"));
        friends.put("friend4", Arrays.asList("friend1"));

        Map<String, List<String>> notFriendsWithCommonFriends = CalculateStreams.getNotFriendsWithCommonFriends(friends);
        System.out.println("task 4");
        for (Map.Entry<String, List<String>> entry : notFriendsWithCommonFriends.entrySet()) {
            System.out.println("person name: " + entry.getKey());
            System.out.println("common friends: " + entry.getValue());
        }

        Employee employee1 = new Employee("name1", "department1", 12);
        Employee employee2 = new Employee("name2", "department1", 15);
        Employee employee3 = new Employee("name3", "department2", 22);
        Employee employee4 = new Employee("name4", "department2", 15);

        Map<String, Double> averageSalaryByDepartment = CalculateStreams.getAverageSalaryByDepartment(Arrays.asList(employee1, employee2, employee3, employee4));
        System.out.println("task 5, averageSalaryByDepartment: " + averageSalaryByDepartment);

        List<String> wordsList = Arrays.asList("apple", "banana", "123", "dog", "cat");
        String[] charArray = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };
        List<String> listContainsLettersByLength = CalculateStreams.getListContainsLettersByLength(wordsList, charArray);
        System.out.println("task 6. listContainsLettersByLength: " + listContainsLettersByLength);

        List<Integer> integerList = List.of(1, 2, 3, 4);
        List<String> binaryList = CalculateStreams.toBinaryList(integerList);
        System.out.println("task 7 binaryList: " + binaryList);

        List<Integer> palindromeNumbersByRange = CalculateStreams.getPalindromeNumbersByRange(23, 500);
        System.out.println("task 8 palindrome numbers to range: " + palindromeNumbersByRange);
    }
}
