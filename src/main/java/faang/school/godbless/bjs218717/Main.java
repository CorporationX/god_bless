package faang.school.godbless.bjs218717;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, 25, "Dude1", Set.of("running", "swimming", "football"));
        User user2 = new User(2, 27, "Dude2", Set.of("running", "tennis", "hockey"));
        User user3 = new User(3, 32, "Dude3", Set.of("hockey", "boxing", "walking"));

        System.out.println(User.findHobbyLovers(List.of(user1, user2, user3), Set.of("boxing", "hockey", "walking")));
    }
}
