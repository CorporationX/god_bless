package school.faang.weCollectUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindHobbyLoversTest {
    public static void main(String[] args) {
        Set<String> activity = new HashSet<>();
        activity.add("Poll");
        activity.add("Work");
        activity.add("Pictures");
        activity.add("Swim");
        activity.add("Developer");

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Vlad", 29, new HashSet<>(Arrays.asList("Pool", "Growy"))));
        userList.add(new User(2, "Max", 29, new HashSet<>(Arrays.asList("Fang", "Work"))));
        userList.add(new User(3, "Jon", 25, new HashSet<>(Arrays.asList("Fang", "Growy"))));
        userList.add(new User(4, "Bob", 40, new HashSet<>(Arrays.asList("Developer", "Growy"))));
        userList.add(new User(5, "Nika", 19, new HashSet<>(Arrays.asList("Swim", "large"))));
        userList.add(new User(6, "Vika", 20, new HashSet<>(Arrays.asList("Sample", "Growy", "Pool"))));

        System.out.println(User.findHobbyLovers(userList, activity));

    }
}
