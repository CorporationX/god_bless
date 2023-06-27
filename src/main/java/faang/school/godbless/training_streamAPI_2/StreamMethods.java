package faang.school.godbless.training_streamAPI_2;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethods {
    public static Map<Integer, Integer> uniqueNumbers(List<Integer> nums, int sum) {
        Set<Integer> processedNums = new HashSet<>();
        return nums.stream()
                .distinct()
                .filter(num -> !processedNums.contains(num) && nums.contains(sum - num))
                .collect(Collectors.toMap(Function.identity(), num -> {
                    processedNums.add(sum - num);
                    return sum - num;
                }));
    }

    public static List<String> sortCountriesAndCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringByFirstLetter(List<String> strings, char letter) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /*На каждый entrySet user создается еще один entrySet another, как цикл в цилке. И там произовдится фильтрация.
     *Далее another изменяется на entrySet который содержит ключ user и ключ another. Из этого entrySet создается мапа.
     *Додумался не сам.*/
    public static Map<String, String> mutualFriends(Map<String, List<String>> friends) {
        Set<String> processedFriend = new HashSet<>();
        return friends.entrySet().stream()
                .flatMap(user -> friends.entrySet().stream()
                        .filter(another -> !user.getKey().equals(another.getKey()))
                        .filter(another -> !user.getValue().contains(another.getKey()))
                        .filter(another -> another.getValue().stream().anyMatch(user.getValue()::contains))
                        .filter(another -> !processedFriend.contains(another.getKey()))
                        .map(another -> {
                            processedFriend.add(user.getKey());
                            return Map.entry(user.getKey(), another.getKey());
                        }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabet.contains(String.valueOf((char) ch))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> numberToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    /* Решение Светы
    return IntStream.rangeClosed(start, end)
                .filter(i -> {
                    String number = Integer.toString(i);
                    return IntStream.range(0, number.length() / 2)
                            .allMatch(j -> number.charAt(j) == number.charAt(number.length() - j - 1));
                })
                .boxed()
                .toList();*/
    public static List<Integer> getPalindromeNumbers(int start, int end) {
        List<Integer> nums = IntStream.range(start, end).boxed().toList();
        Predicate<Integer> isPalindrome = num -> {
            String revers = new StringBuilder(num.toString()).reverse().toString();
            Integer reversedNum = Integer.parseInt(revers);
            return num.equals(reversedNum);
        };
        return nums.stream().filter(isPalindrome).toList();
    }

    public static List<String> getPalindromeStrings(String string) {
        String[] words = string.split("\\W+");
        Predicate<String> isPalindrome = str -> {
            String revers = new StringBuilder(str).reverse().toString();
            return str.equalsIgnoreCase(revers);
        };
        return Arrays.stream(words).filter(isPalindrome).toList();
    }

    public static List<Integer> getPerfectNumbers(int start, int end) {
        List<Integer> nums = IntStream.range(start, end).boxed().toList();
        Predicate<Integer> isPerfect = num -> {
            int sum = 0;
            for (int i = 1; i < num; i++) {
                if (num % i == 0 && sum <= num)
                    sum += i;
            }
            return sum == num;
        };
        return nums.stream().filter(isPerfect).toList();
    }
}
