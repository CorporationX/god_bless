package school.faang.BJS2_85446;

import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Ale1", 16, Set.of("golf", "programming", "tennis"));
        User user2 = new User(2L, "Ale2", 16, Set.of("swimming", "programming"));
        User user3 = new User(3L, "Ale3", 16, Set.of("programming"));
        User user4 = new User(4L, "Ale4", 16, Set.of("autosport", "gaming", "chatting"));

        System.out.println(User.findHobbyLovers(List.of(user1, user2, user3, user4), Set.of("programming", "autosport", "golf")));
    }
}
