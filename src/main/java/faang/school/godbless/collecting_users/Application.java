package faang.school.godbless.collecting_users;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        User user1 = new User(1, "Alisa", 20, Set.of("dancing", "shooting", "boxing"));
        User user2 = new User(2, "Volodya", 58, Set.of("dancing", "cooking", "eating"));
        User user3 = new User(2, "Tima", 12, Set.of("gaming", "cooking", "eating"));
        System.out.println(User.findHobbyLovers(List.of(user1, user2, user3), Set.of("dancing", "eating")));

    }
}
