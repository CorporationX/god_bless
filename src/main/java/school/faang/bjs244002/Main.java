package school.faang.bjs244002;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        User parvin = new User(1L, "Parvin", 33, List.of("football", "chess", "workout"));
        User ali = new User(2L, "Ali", 23, List.of("football", "music", "painting"));
        User narmin = new User(3L, "Narmin", 30, List.of("reading", "walking"));
        User azer = new User(4L, "Azer", 33, List.of("reading", "dancing"));
        User fariz = new User(5L, "Fariz", 33, List.of());

        List<User> users = List.of(parvin, ali, narmin, azer, fariz);

        Map<User, String> hobbyLovers = parvin.findHobbyLovers(users,
                List.of("football", "chess", "workout", "music", "painting", "reading", "walking"));
        System.out.println(hobbyLovers);

    }
}
