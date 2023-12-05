package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String... args) {
        User user1 = new User("ivan", 15, "faang","lermontova");
        User user2 = new User("petia", 15, "zavod","lenina");
        User user3 = new User("lena", 16, "pecarnia","perspectivnaia");

        List<User> users = List.of(user1, user2, user3);

        System.out.println(User.groupUsers(users));

    }
}
