package faang.school.godbless;


import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CommonFriends {
    public static void main(String[] args) {


        Map<String, List<String>> mapFriends = new HashMap<>() {{
            put("Alice", Arrays.asList("Bob", "Charlie"));
            put("Bob", Arrays.asList("Alice", "David"));
            put("Charlie", Arrays.asList("Alice", "David"));
            put("David", Arrays.asList("Bob", "Charlie"));

        }};

        var commonFriends = findCommonFriends(mapFriends);
        commonFriends.forEach(System.out::println);
    }


    public static List<List<String>> findCommonFriends(Map<String, List<String>> friendsMap) {
        Set<List<String>> pairsSet = new HashSet<>();

        friendsMap.keySet().stream()
                .flatMap(person ->
                        friendsMap.keySet().stream()
                                .filter(otherPerson -> !otherPerson.equals(person))
                                .filter(otherPerson -> !friendsMap.get(person).contains(otherPerson))
                                .filter(otherPerson -> hasCommonFriends(person, otherPerson, friendsMap))
                                .map(otherPerson -> Arrays.asList(person, otherPerson))
                )
                .forEach(pair -> {
                    List<String> sortedPair = pair.stream().sorted().collect(Collectors.toList());
                    pairsSet.add(sortedPair);
                });

        return new ArrayList<>(pairsSet);
    }

    private static boolean hasCommonFriends(String friend, String otherFriend, Map<String, List<String>> friendsMap) {
        Set<String> setFriend = new HashSet<>(friendsMap.get(friend));
        Set<String> setOtherFriend = new HashSet<>(friendsMap.get(otherFriend));

        setFriend.retainAll(setOtherFriend);
        return !setFriend.isEmpty();
    }
}
