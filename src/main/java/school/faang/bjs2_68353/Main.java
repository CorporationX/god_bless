package school.faang.bjs2_68353;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String [] args) {
        var users = Arrays.asList(
                new User(
                        UUID.randomUUID(),
                        "Михаил",
                        28,
                        new HashSet<>(Set.of("Reading", "Review"))
                ),
                new User(
                        UUID.randomUUID(),
                        "Андрей",
                        33,
                        new HashSet<>(Set.of("Basketball", "Bulling", "Swimming"))
                ),
                new User(
                        UUID.randomUUID(),
                        "Виктория",
                        22,
                        new HashSet<>(Set.of("Review", "Basketball"))
                )
        );
        var activities = Set.of("Reading", "Review", "Basketball", "Bulling", "Swimming", "NotListedHobby");

        var hobbyLovers = User.findHobbyLovers(users, activities);
        System.out.println(hobbyLovers);
    }
}