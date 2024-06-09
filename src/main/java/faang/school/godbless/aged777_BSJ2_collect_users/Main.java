package faang.school.godbless.aged777_BSJ2_collect_users;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> userActivities = new ArrayList<>();
        userActivities.add("Sport");
        userActivities.add("Chess");
        userActivities.add("Pool");
        userActivities.add("Computer games");
        userActivities.add("Work");

        List<String> desiredActivities = new ArrayList<>();
        desiredActivities.add("Chess");

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Username1", 23, userActivities));
        users.add(new User(2, "Username2", 33, userActivities));
        users.add(new User(3, "Username3", 43, userActivities));
        users.add(new User(4, "Username4", 53, userActivities));
        users.add(new User(5, "Username5", 63, userActivities));

        System.out.println(User.findHobbyLovers(users, desiredActivities));
    }
}
