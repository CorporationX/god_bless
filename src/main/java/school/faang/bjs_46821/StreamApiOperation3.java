package school.faang.bjs_46821;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamApiOperation3 {
    public static Map<String, String> noFriendsPair(Map<String, List<String>> users) {
        Map<String, String> noFriendsPair = new HashMap<>();

        users.forEach((user, friendList) -> friendList.forEach(friend -> users.get(friend).stream()
                .filter(f -> !f.equals(user) && !friendList.contains(f) && !noFriendsPair.containsKey(f))
                .forEach(f -> noFriendsPair.put(user, f))));

        return noFriendsPair;
    }

}
