package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("1", "Stanly", 20, Set.of("Sport", "Music"));
        User user2 = new User("2", "Tom", 30, Set.of("Book", "Art"));
        User user3 = new User("3", "Sam", 40, Set.of("Sport", "Games"));

        Map<User, String> test = User.findHobbyLovers(
                List.of(user1, user2, user3),
                Set.of("Sport", "Games")
        );

        test.forEach((user, hobby) -> System.out.println(user.getName() + " likes " + hobby));
    }
}