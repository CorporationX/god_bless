package faang.school.godbless.Denalg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Denis", 1, 31, Set.of("Football", "Basketball"));
        User user2 = new User("Ivan", 2, 20, Set.of("Tennis", "Boxing"));

        Map<User, String> result = User.findHobbyLovers(Arrays.asList(user1, user2),
                new HashSet<>(Arrays.asList("Football", "Shooting")));
        System.out.println(result);
    }
}
