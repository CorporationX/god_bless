package userCollection;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> listActivity = Set.of("act1", "act2", "act3");
        List<User> listUser = List.of(
                new User(1, "Vadim", 35, Set.of("act1", "act4")),
                new User(1, "Anna", 24, Set.of("act6", "act4")),
                new User(1, "Kirill", 24, Set.of("act3", "act10"))
        );
        System.out.println(listActivity);
        System.out.println(listUser);
        System.out.println(User.findHobbyLovers(listUser, listActivity));
    }
}