package faang.school.godbless.beksultan2005;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activity1 = Set.of("football", "voleyball");
        Set<String> activity2 = Set.of("voleyball", "basketball");

        User user1 = new User(1, "Beks", 19, activity1);
        User user2 = new User(2, "Sula", 28, activity2);

        Map<User, String> result = User.findHobbyLovers(Arrays.asList(user1, user2), new HashSet<>(Arrays.asList("voleyball", "swimming")));

        System.out.println(result.toString());
    }
}
