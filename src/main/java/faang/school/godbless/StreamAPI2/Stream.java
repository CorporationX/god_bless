package faang.school.godbless.StreamAPI2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stream {

    public static Set<List<Integer>> pairsOfNumbers(List<Integer> nums, Integer num) {
        Set<List<Integer>> pairs = new HashSet<>();
        nums.stream().forEach(
                (x) -> nums.stream()
                        .filter((y) -> nums.indexOf(x) != nums.lastIndexOf(y))
                        .filter((y) -> x + y == num)
                        .filter((y) -> !pairs.contains(List.of(y, x)))
                        .forEach((y) -> pairs.add(List.of(x, y)))
        );

        return pairs;
    }

    public static void countriesAlphabetically(Map<String, String> countries) {

        countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList().forEach(System.out::println);

    }

    public static List<String> getSortedStrings(List<String> strings, char ch){
        return strings.stream().filter((s) -> s.startsWith(Character.toString(ch))).sorted((s1, s2) -> s1.length()-s2.length()).toList();
    }

//    public static Set<List<String>> getFriendsOfFriends(Map<String, List<String>> friends){
//        Set<List<String>> pairs = new HashSet<>();
//
//        friends.entrySet().stream().forEach(
//                (x) -> friends.entrySet().stream().filter(x.getValue()::contains)
//        );
//
//        return pairs;
//    }
}
