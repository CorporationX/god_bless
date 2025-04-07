package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities = Set.of("Main", "Main1", "Main2");
        List<User> users = new ArrayList<>();
        User user = new User(1, "Daniyal", 22, activities);
        User user1 = new User(2, "Nazar", 21, Set.of("Main", "School1", "School2"));
        User user2 = new User(3, "Misha", 22, Set.of("School", "School1", "School2"));
        User user3 = new User(4, "Sasha", 34, Set.of("School", "School1", "School2"));
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Map<User, String> hobbyLovers = user.findHobbyLovers(users, activities);
        System.out.println(hobbyLovers);
    }
}


