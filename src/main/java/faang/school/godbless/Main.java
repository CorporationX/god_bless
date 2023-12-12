package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activity1 = Set.of("hockey", "footbal", "bowling");
        Set<String> activity2 = Set.of("boxing", "karate", "kickboxing");
        Set<String> activity3 = Set.of("dancing", "swimming", "singing");
        Set<String> activity4 = Set.of("chess", "checkers", "bowling");
        Set<String> activity5 = Set.of("chess", "bowling");

        User user1 = new User(1L, "Roma", 20, activity1);
        User user2 = new User(2L, "Mark", 43, activity4);
        User user3 = new User(3L, "Rob", 18, activity2);
        User user4 = new User(4L, "Kirill", 24, activity3);
        User user5 = new User(5L, "Mihail", 33, activity2);


        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<User, String> printUserHobby = User.findHobbyLovers(users, activity5);
        if (printUserHobby != null) {
            for (Map.Entry<User, String> entry : printUserHobby.entrySet()) {
                User user = entry.getKey();
                String userName = user.getName();
                String userHobby = entry.getValue();
                System.out.println(userName + " - " + userHobby);
            }
        }
    }
}