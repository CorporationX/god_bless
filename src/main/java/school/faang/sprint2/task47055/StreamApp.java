package school.faang.sprint2.task47055;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamApp {
    public static void main(String[] args) {


        Map<String, List<String>> friends = new HashMap<>();

        List<String> aliceFriends = new ArrayList<>();
        aliceFriends.add("Bob");
        aliceFriends.add("Charlie");
        friends.put("Alice", aliceFriends);

        List<String> bobFriends = new ArrayList<>();
        bobFriends.add("Alice");
        bobFriends.add("David");
        friends.put("Bob", bobFriends);

        List<String> charlieFriends = new ArrayList<>();
        charlieFriends.add("Alice");
        charlieFriends.add("David");
        friends.put("Charlie", charlieFriends);

        List<String> davidFriends = new ArrayList<>();
        davidFriends.add("Bob");
        davidFriends.add("Charlie");
        friends.put("David", davidFriends);

        List<List<String>> friendsOfFriends;

        friendsOfFriends = StreamFunc.getFriendsOfFriends(friends);
    }
}
