package faang.school.godbless.collerctions_user;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        User user = new User(
                UUID.randomUUID(),
                "John",
                30,
                new HashSet<>(Set.of("Basketball", "Football", "Volleyball"))
        );

        User findHobbyUser = new User(
                UUID.randomUUID(),
                "Eve",
                21,
                new HashSet<>(Set.of("Tennis", "Football", "Volleyball", "Rugby"))
        );

        Map<User, String> hobbyLovers = user.findHobbyLovers(
                List.of(findHobbyUser, user),
                new HashSet<>(Set.of("Basketball"))
        );

        System.out.println(hobbyLovers.get(user));
    }
}
