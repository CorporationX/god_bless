package faang.school.godbless.streamAPI2;

import java.util.*;
import java.util.stream.Collectors;

public class StaticMethod {
    public static List<List<Integer>> pairChisel(List<Integer> nums, Integer element) {
        Set<Integer> result = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        nums.stream().distinct().forEach(num -> {
            Integer target = element - num;
            result.add(num);
            if (nums.contains(target) && !result.contains(target)) {
                result.add(target);
                pairs.add(List.of(target, num));
            }
        });
        return pairs;
    }

    public static List<String> cityList(HashMap<String, String> cityCapital) {
        return cityCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(city -> city.getValue())
                .collect(Collectors.toList());
    }

    public static List<String> wordList(List<String> str, char word) {
        return str.stream().filter(s -> s.charAt(0) == word)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> friendsPair(HashMap<String, List<String>> friends) {
        return friends.entrySet()
                .stream()
                .flatMap(person1 -> friends.entrySet().stream()
                        .filter(person2 -> !person2.getKey().equals(person1.getKey()))
                        .filter(person2 -> !person1.getValue().contains(person2.getKey()))
                        .filter(person2 -> person1.getValue().stream()
                                .anyMatch(person2.getValue()::contains))
                        .map(person2 -> {
                            String nameFirst = person1.getKey();
                            String nameSecond = person2.getKey();
                            if (nameFirst.compareTo(nameSecond) < 0) {
                                return nameFirst + " " + nameSecond;
                            } else {
                                return nameSecond + " " + nameFirst;
                            }
                        }))
                .distinct()
                .toList();
    }

    public static Map<String, Double> averageSalary(List<Employee> employee) {
        return employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> sortWord(List<String> strWord, List<Character> characters) {
        return strWord.stream()
                .filter(s -> s.chars().allMatch(sl -> characters.contains(sl)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> integerInString(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> palindrome(int firstNum, int secondNum) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < secondNum-firstNum + 1; i++) {
            result.add(firstNum + i);
        }
        return result.stream()
                .filter(n ->String.valueOf(n).contentEquals(new StringBuilder(String.valueOf(n)).reverse()))
                .toList();
    }
}
