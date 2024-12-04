package school.faang.sprint1.task_43993;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(
                1,
                "rauan",
                25,
                "netflix",
                "football",
                "hockey"
        );
        User user2 = new User(
                2,
                "jack",
                23,
                "football",
                "paintball"
        );
        Map<User, String> map = User.findHobbyLovers(
                List.of(user1, user2),
                "paintball", "netflix"
        );
        System.out.println(map);
    }
}
