package school.faang.BJS2_85446;

import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "Ale1", 16, Set.of("golf", "programming", "tennis")),
                new User(2L, "Ale2", 16, Set.of("swimming", "programming")),
                new User(3L, "Ale3", 16, Set.of("programming")),
                new User(4L, "Ale4", 16, Set.of("autosport", "gaming", "chatting")));

        System.out.println(
                        User.findHobbyLovers(
                                users,
                                Set.of("programming", "autosport", "golf")
                        ));
    }
}
