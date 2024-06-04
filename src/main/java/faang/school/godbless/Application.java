package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("User1", 20, "Google", "New York"),
                new User("User2", 18, "Google", "New York"),
                new User("User3", 18, "Google", "New York"),
                new User("User4", 18, "Google", "New York"),
                new User("User5", 19, "Google", "New York"),
                new User("User6", 19, "Google", "New York"),
                new User("User7", 19, "Google", "New York"),
                new User("User8", 19, "Google", "New York"),
                new User("User9", 19, "Google", "New York")
        );
        User.groupUser(users).forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
