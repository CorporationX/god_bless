package faang.school.godbless.beksultan2005;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Set<String> activity1 = new HashSet<>();
        Set<String> activity2 = new HashSet<>();

        activity1.add("football");
        activity1.add("voleyball");

        activity2.add("voleyball");
        activity2.add("basketball");

        User user1 = new User(1, "Beks", 19, activity1);
        User user2 = new User(2, "Sula", 28, activity2);

        Map<User, String> result = User.findHobbyLovers(Arrays.asList(user1, user2), new HashSet<>(Arrays.asList("voleyball", "swimming")));

        System.out.println(result.toString());
    }
}
