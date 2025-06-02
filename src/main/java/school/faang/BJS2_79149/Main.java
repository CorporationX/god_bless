package school.faang.BJS2_79149;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(0, "John", 20, Set.of("swimming", "football"));
        User user2 = new User(1, "Alex", 22, Set.of("swimming", "basketball"));
        User user3 = new User(2, "Bob", 23, Set.of("running", "football"));
        User user4 = new User(3, "Kale", 24, Set.of("football", "running"));
        User user5 = new User(3, "Kale", 24, Set.of("volleyball"));

        List<User> usersForCompare = List.of(user1, user2, user3, user4, user5);

        Set<String> activitiesForCompare = Set.of("swimming", "football");

        Map<User, String> groupedUsers = User.findHobbyLovers(usersForCompare, activitiesForCompare);

        System.out.println(groupedUsers);
    }
}
