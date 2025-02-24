package school.faang.task_bjs244036;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Egor", 21, new HashSet<>());
        user1.getActivities().add("football");
        user1.getActivities().add("swimming");
        user1.getActivities().add("dancing");
        user1.getActivities().add("playing");

        User user2 = new User(2, "Igor", 15, new HashSet<>());
        user2.getActivities().add("swimming");
        user2.getActivities().add("dancing");

        User user3 = new User(3, "Sasha", 17, new HashSet<>());
        user3.getActivities().add("dancing");
        user3.getActivities().add("playing");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Set<String> hobbiesSet = new HashSet<>();
        hobbiesSet.add("playing");
        hobbiesSet.add("dancing");

        System.out.println(User.findHobbyLovers(users, hobbiesSet));
    }
}
