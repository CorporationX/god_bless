package faang.school.godbless.train.stream.api.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTrainingSecond {

    public static List<List<Integer>> findPairs(List<Integer> nums, int target) {
        return IntStream.range(0, nums.size() - 1)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.size())
                        .mapToObj(j -> List.of(nums.get(i), nums.get(j))))
                .filter(pair -> pair.get(0) + pair.get(1) == target)
                .distinct()
                .toList();
    }

    public static List<String> getCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> specialSort(List<String> lines, char letter) {
        return lines.stream()
                .filter(line -> line.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Set<List<String>> findCommonFriendsForKeys(Map<String, List<String>> personFriendsMap) {
        return personFriendsMap.keySet().stream()
                .flatMap(person1 -> personFriendsMap.keySet().stream()
                        .filter(person2 -> !person2.equals(person1))
                        .filter(person2 -> !Collections.disjoint(personFriendsMap.get(person1), personFriendsMap.get(person2)))
                        .filter(person2 -> !personFriendsMap.get(person2).contains(person1))
                        .filter(person2 -> !personFriendsMap.get(person1).contains(person2))
                        .map(person2 -> {
                            List<String> pair = Arrays.asList(person1, person2);
                            Collections.sort(pair);
                            return pair;
                        }))
                .collect(Collectors.toSet());
    }

    public static Set<List<String>> findCommonFriendsForAllPeople(Map<String, List<String>> personFriendsMap) {

        Map<String, List<String>> commonMap = new HashMap<>(personFriendsMap);
        personFriendsMap.forEach((keyPerson, keyPersonFriends) ->
                keyPersonFriends.forEach(friendOfKeyPersonFriend ->
                        commonMap.compute(friendOfKeyPersonFriend, (friendKey, friendsList) -> {
                            List<String> updatedFriendsList = friendsList == null ? new ArrayList<>() : new ArrayList<>(friendsList);
                            if (!updatedFriendsList.contains(keyPerson)) {
                                updatedFriendsList.add(keyPerson);
                            }
                            return updatedFriendsList;
                        })
                )
        );

        return findCommonFriendsForKeys(commonMap);
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, HashMap::new, Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> filterByAlphabet(List<String> words, char[] letters) {
        return words.stream()
                .filter(word -> word.chars().allMatch(ch -> contains(letters, (char) ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .filter(StreamApiTrainingSecond::isPalindrome)
                .boxed()
                .toList();
    }

    private static Map<Character, List<Integer>> getCharIndexes(String line) {
        Map<Character, List<Integer>> charIndexes = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            List<Integer> indexes = charIndexes.getOrDefault(ch, new ArrayList<>());
            indexes.add(i);
            charIndexes.putIfAbsent(ch, indexes);
        }
        return charIndexes;
    }

    private static boolean contains(char[] array, char ch) {
        for (char c : array) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(int number) {
        String string = String.valueOf(number);
        return IntStream.range(0, string.length() / 2)
                .allMatch(i -> string.charAt(i) == string.charAt(string.length() - i - 1));
    }


}
