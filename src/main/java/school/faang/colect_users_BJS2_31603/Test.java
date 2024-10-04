package school.faang.colect_users_BJS2_31603;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice Johnson", 28, "Running", "Reading", "Traveling");
        User user2 = new User(2, "Bob Smith", 35, "Cycling", "Hiking", "Running");
        User user3 = new User(3, "Charlie Brown", 22, "Gaming", "Programming", "Music");
        User user4 = new User(4, "Diana Wilson", 30, "Yoga", "Programming", "Painting");

        List<String> activities = new ArrayList<>(List.of("Running", "Gaming", "Painting"));
        List<User> users = new ArrayList<>(List.of(user1, user2, user3, user4));

        System.out.println(user1.findHobbyLovers(users, activities));
    }
}
