package faang.school.godbless;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class streamApiMethod {
    public static Set<List<Integer>> findUniquePairs(List<Integer> list, int sum){
        Set<Integer> numbers = new HashSet<>(list);
        Set<List<Integer>> uniquePairs = new HashSet<>();

        Set<Integer> rightNumbers = numbers.stream()
                .map(number -> sum - number).collect(Collectors.toSet());

        numbers.stream()
                .filter(number -> rightNumbers.contains(number) && sum - number > number)
                .forEach(number -> uniquePairs.add(List.of(number, sum - number)));
        return uniquePairs;
    }

    public static List<String> listOfCapitals(Map<String, String> countyMap){
        return countyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filteredLines(List<String> lines, char letter){
        return lines.stream()
                .filter(line -> line.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Map<String, String> findMutualFriends(Map<String, List<String>> people){
        Map<String, String> result = new HashMap<>();
        people.forEach((user, friend) -> people.forEach((another, anotherFriend) -> {
            if(!user.equals(another) && !friend.contains(another)){
                friend.stream()
                        .filter(anotherFriend::contains)
                        .findFirst()
                        .ifPresent(someFriend -> result.put(user, another));
            }
        }));
        return result;
    }

    public static Map<String, Double> avgSalary(List<Employee> employees){
        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        return map;
    }

    public static List<String> findAlphabetStrings(List<String> lines, List<Character> alphabet){
        return lines.stream()
                .filter(line -> line.matches("["+alphabet+"]+")).toList();
    }

    public static List<String> numberToBinary(List<Integer> numbers){
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromes(int first, int last){
        return IntStream.range(first, last)
                .filter(number -> {
                    String str = String.valueOf(number);
                    int left = 0;
                    int right = str.length()-1;
                    while(left < right){
                        if(str.charAt(left) != str.charAt(right)){
                            return false;
                        }
                        left++;
                        right++;
                    }
                    return true;
                }).boxed().toList();
    }
}
