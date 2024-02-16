package Basic.Task4;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "sam", 22, Set.of("football", "book", "music"));
        User user2 = new User(2, "tom", 24, Set.of("it", "dance", "films"));
        List<User> users = List.of(user1, user2);
        Set<String> activities = Set.of("game", "it");
        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, activities);
        System.out.println(hobbyLovers);
    }
}
