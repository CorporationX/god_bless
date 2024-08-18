package faang.school.godbless.BJS2_22550;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static List<List<Integer>> findPairsWithX(List<Integer> numbers, int x) {
        return numbers.stream()
                .flatMap(firstNum -> numbers.stream()
                        .filter(secondNum -> firstNum + secondNum == x && !firstNum.equals(secondNum))
                        .map(secondNum -> List.of(Math.min(firstNum, secondNum), Math.max(firstNum, secondNum))))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> filterCountryByCapital(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringByX(List<String> stringList, char x) {
        return stringList.stream()
                .filter(string -> string.startsWith(String.valueOf(x)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> findNoFriends(Map<String, List<String>> mapOfFriendsList) {
        return mapOfFriendsList.entrySet().stream()
                .flatMap(friend -> mapOfFriendsList.keySet().stream()
                        .filter(otherFriend -> !friend.getKey().equals(otherFriend))
                        .filter(otherFriend -> !friend.getValue().contains(otherFriend))
                        .map(otherFriend -> Stream.of(friend.getKey(), otherFriend)
                                .sorted()
                                .collect(Collectors.toList()))
                        .filter(pair -> {
                            String firstFriend = pair.get(0);
                            String secondFriend = pair.get(1);
                            Set<String> commonFriends = new HashSet<>(mapOfFriendsList.get(firstFriend));
                            commonFriends.retainAll(mapOfFriendsList.get(secondFriend));
                            return !commonFriends.isEmpty();
                        })
                )
                .distinct()
                .collect(Collectors.toList());
    }
    public static Map<String, Double> findDepartmentWithAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }
    public static List<String> filterAndSortingStrings(List<String> stringList, String alphabet) {
        return stringList.stream()
                .filter(string -> string.chars().allMatch(chars -> alphabet.indexOf(chars) >=0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    public static List<String> integersToBinaryViewStrings(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
    public static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    String str = Integer.toString(num);
                    return str.contentEquals(new StringBuilder(str).reverse());
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
