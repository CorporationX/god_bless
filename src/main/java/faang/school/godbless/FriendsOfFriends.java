package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FriendsOfFriends {
    public static List<String> lookingForFriendsOfFriends(Map<String, List<String>> friends) {
            return friends.entrySet().stream()
                    .flatMap(personEntry -> friends.entrySet().stream()
                            .filter(friendEntry -> !friendEntry.getKey().equals(personEntry.getKey()))
                            .filter(friendEntry -> personEntry.getValue().contains(friendEntry.getKey()))
                            .filter(friendEntry -> haveCommonFriends(personEntry.getValue(), friendEntry.getValue()))
                            .map(friendEntry -> personEntry.getKey() + " - " + friendEntry.getKey()))
                                    .collect(Collectors.toList());


    }
    public static boolean haveCommonFriends(List<String> friends1, List<String> friends2) {
        return friends2.stream().anyMatch(friends1::contains);
    }
}