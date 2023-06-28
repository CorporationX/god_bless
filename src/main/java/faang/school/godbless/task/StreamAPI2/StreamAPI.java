package faang.school.godbless.task.StreamAPI2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {

    public static List<List<Integer>> getSumPairs(List<Integer> numbers, int sum) {
        return numbers.stream()
                .map(number -> {
                    List<List<Integer>> pairs = new ArrayList<>();
                    boolean isThis = true;
                    for (int num : numbers) {
                        if (num + number == sum) {
                            if (num == number) {
                                if (isThis) {
                                    isThis = false;
                                } else {
                                    pairs.add(new ArrayList<>(List.of(num, number)));
                                    break;
                                }
                            } else {
                                List<Integer> sumPairs = new ArrayList<>(List.of(num, number));
                                Collections.sort(sumPairs);
                                pairs.add(sumPairs);
                                break;
                            }
                        }
                    }
                    return pairs;
                })
                .flatMap(Collection::stream)
                .distinct()
                .toList();

    }

    public static List<String> getSortedByCountryCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getStringsStartsWithCharSortedByLength(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getPairOfNonFriendsWithMutualFriend(Map<String, Set<String>> manFriends) {
        return manFriends.entrySet().stream()
                .map(es -> {
                    List<List<String>> friendsOfFriends = new ArrayList<>();
                    for (String friend : es.getValue()) {
                        if (manFriends.containsKey(friend)) {
                            for (String friendOfFriend : manFriends.get(friend)) {
                                if ((!es.getValue().contains(friendOfFriend)) && (!es.getKey().equals(friendOfFriend))) {
                                    List<String> manAndFriendOfHisFriend = new ArrayList<>(List.of(es.getKey(), friendOfFriend));
                                    Collections.sort(manAndFriendOfHisFriend);
                                    friendsOfFriends.add(manAndFriendOfHisFriend);
                                }
                            }
                        }
                    }
                    return friendsOfFriends;
                })
                .flatMap(Collection::stream)
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSalaryForDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<String> getStringsWhichContainLetterAndSortedByLength(List<String> strings, CharSequence alphabet) {
        return strings.stream()
                .filter(s -> s.matches("^[" + alphabet + "]+$"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> getBinaryStringFromDecimal(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getPalindromeForDiapason(List<Integer> integers, int diapasonStart, int diapasonEnd) {
        return integers.stream()
                .filter(integer -> {
                    if ((diapasonStart > String.valueOf(integer).length()) || (diapasonEnd > String.valueOf(integer).length())) {
                        throw new IllegalArgumentException("invalid diapason for the given number");
                    }
                    StringBuilder subString = new StringBuilder(String.valueOf(integer).substring(diapasonStart - 1, diapasonEnd));
                    return subString.toString().contentEquals(subString.reverse());
                })
                .toList();
    }

    public record Employee(String name, double salary, String department) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 5, 2, 3, 32, 5, -3, 0, 0, 4, 4, 3, -1, 1);
        System.out.println(getSumPairs(numbers, 4));
        Map<String, String> countryCapital = new HashMap<>() {{
            put("Russia", "Moscow");
            put("France", "Paris");
            put("USA", "Washington");
            put("England", "London");
        }};
        System.out.println(getSortedByCountryCapitals(countryCapital));

        System.out.println(getStringsStartsWithCharSortedByLength(List.of("home", "house", "honey", "cat", "hi", "bag"), 'h'));

        Map<String, Set<String>> manFriends = new HashMap<>() {{
            put("Marsel", Set.of("Ignat", "Sveta", "Pasha"));
            put("Alyosha", Set.of("Ignat", "Akkakiy", "Pasha"));
            put("Ignat", Set.of("Marsel", "Alyosha", "Masha"));
            put("Akkakiy", Set.of("Alyosha", "Ksusha", "Sveta"));
            put("Sveta", Set.of("Marsel", "Akkakiy", "Ksusha"));
            put("Masha", Set.of("Ignat", "Pasha"));
            put("Ksusha", Set.of("Akkakiy", "Sveta", "Pasha"));
            put("Pasha", Set.of("Marsel", "Alyosha", "Masha", "Ksusha"));
        }};
        System.out.println(getPairOfNonFriendsWithMutualFriend(manFriends));

        List<Employee> employees = List.of(
                new Employee("Marsel", 10000, "1"),
                new Employee("Alyosha", 500, "2"),
                new Employee("Ignat", 1000000, "1"),
                new Employee("Akkakiy", 5000, "1"),
                new Employee("Sveta", 100000, "2")
        );
        System.out.println(getAverageSalaryForDepartment(employees));

        System.out.println(getStringsWhichContainLetterAndSortedByLength(List.of("home", "house", "chrome", "cat", "hi", "bag"), "abcDfghi"));

        System.out.println(getBinaryStringFromDecimal(List.of(0, 1, 2, 4, 10, 999)));

        System.out.println(getPalindromeForDiapason(List.of(78111115, 97654567, 23456654, 12423189), 3, 7));
    }
}
