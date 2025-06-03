package school.faang.collect_users_bjs2_79149;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> usersForCompare = List.of(new User(0, "John", 20, Set.of("swimming", "football")),
                new User(1, "Alex", 22, Set.of("swimming", "basketball")),
                new User(2, "Bob", 23, Set.of("running", "football")),
                new User(3, "Kale", 24, Set.of("football", "running")),
                new User(4, "Kate", 24, Set.of("volleyball"))
                );

        Set<String> activitiesForCompare = Set.of("swimming", "football");

        Map<User, String> groupedUsers = User.findHobbyLovers(usersForCompare, activitiesForCompare);

        System.out.println(groupedUsers);
    }
}
