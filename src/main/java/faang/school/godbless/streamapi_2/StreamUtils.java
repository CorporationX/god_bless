package faang.school.godbless.streamapi_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamUtils {

    public static List<List<Integer>> uniqueSum(List<Integer> list, Integer num) {
        return IntStream.range(0, (int) list.stream().distinct().count()).boxed()
                .flatMap(x -> IntStream.range(x + 1, (int) list.stream().distinct().count())
                        .mapToObj(y -> List.of(list.get(x), list.get(y))))
                .filter(l -> l.get(0) + l.get(1) == num).toList();
    }

    public static List<String> sortCapitals(Map<String, String> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> sortWords(List<String> list, char ch) {
        return list.stream().filter(word -> word.startsWith(String.valueOf(ch))).sorted().toList();
    }

    public static Map<String, List<String>> friends(Map<String, List<String>> list) {
        Map<String, List<String>> secondFriend = new HashMap<>();
        list.forEach((key, value) -> value.forEach(friend -> list.get(friend).forEach(second -> {
            if (!value.contains(second) && !key.equals(second)) {
                secondFriend.computeIfAbsent(key, k -> new ArrayList<>()).add(second);
            }
        })));
        return secondFriend;
    }

    public static Map<String, Double> branchSalary(List<Employee> list) {
        Map<String, List<Integer>> map = new HashMap<>();
        list.forEach(employee -> map.computeIfAbsent(employee.branch(), k -> new ArrayList<>()).add(employee.salary()));
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().mapToDouble(Integer::doubleValue).average().orElse(0d)));
    }

    public static List<String> filterLanguage(List<String> list, String language) {
        Set<Character> charSet = language.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return list.stream().filter(string -> string.chars().mapToObj(c -> (char) c).allMatch(charSet::contains)).toList();
    }

    public static List<String> toBinaryString(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> palNumber(int start, int end) {
        return IntStream.range(start, end).boxed().filter(num -> {
            int reverse = 0;
            int temp = num;
            while (temp != 0) {
                reverse = (reverse * 10) + (temp % 10);
                temp = temp / 10;
            }
            return (reverse == num);
        }).toList();
    }

    public static List<String> substringPalindrome(String str) {
        List<String> substrings = new ArrayList<>();
        IntStream.range(0, str.length()).forEach(i -> IntStream.range(i, str.length()).forEach(j -> substrings.add(str.substring(i, j + 1))));
        return substrings.stream().filter(s -> {
            if (s.length() == 1) {
                return false;
            }
            return s.contentEquals(new StringBuilder(s).reverse());
        }).distinct().toList();
    }

    public static List<Integer> completeNumber(Integer start, Integer end) {
        return IntStream.range(start, end).boxed().filter(num -> {
            List<Integer> divisors = new ArrayList<>();
            IntStream.range(1, num / 2 + 1).forEach(i -> {
                if (num % i == 0) {
                    divisors.add(i);
                }
            });

            return divisors.stream().reduce(Integer::sum).orElse(0).equals(num);
        }).toList();
    }
}
