package school.faang.BJS2_79151;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class HobbyLovers {
    public static void main(String[] args) {
        List<User> users = List.of(new User(1, "John", 30, Set.of("running", "basketball", "swimming")),
                new User(2, "Mary", 25, Set.of("drawing", "photo", "tennis")),
                new User(3, "Kevin", 23, Set.of("football", "photo", "puzzles")),
                new User(4, "Nicholas", 24, Set.of("football", "swordplay", "horseriding")));

        Set<String> hobbies = Set.of("drawing", "football");

        Map<User, String> userHobbies = User.findHobbyLovers(users, hobbies);
        for (var userHobby : userHobbies.entrySet()) {
            System.out.println(userHobby.getKey() + ", " + userHobby.getValue());
        }
    }
}
