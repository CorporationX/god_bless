package faang.school.godbless.java_core.collecting_users;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users =
                List.of(
                        new User(1, "user_1", 20, Set.of("hobby_1", "hobby_2", "hobby_3")),
                        new User(2, "user_2", 21, Set.of("hobby_4", "hobby_1", "hobby_5")),
                        new User(3, "user_3", 22, Set.of("hobby_43", "hobby_8", "hobby_12")),
                        new User(4, "user_4", 23, Set.of("hobby_3", "hobby_5", "hobby_1")),
                        new User(5, "user_5", 24, Set.of("hobby_8", "hobby_7", "hobby_2")),
                        new User(6, "user_6", 25, Set.of("hobby_10", "hobby_9", "hobby_6")),
                        new User(7, "user_7", 26, Set.of("hobby_16", "hobby_15", "hobby_11")),
                        new User(8, "user_8", 27, Set.of("hobby_13", "hobby_16", "hobby_3"))
                );

        Map<User, String> map = User.findHobbyLovers(users, Set.of("hobby_13", "hobby_143", "hobby_232"));
        System.out.println(map);

    }
}
