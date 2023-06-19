package faang.school.godbless;

import faang.school.godbless.groupUsersByAge.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {
        User alex = new User("Alex", 20, "Google", "London");
        User bob = new User("Bob", 45, "Amazon", "Amsterdam");
        User martin = new User("Martin", 32, "Uber", "Amsterdam");
        User nick = new User("Nick", 20, "Google", "London");
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList, alex, bob, martin, nick);

        Map<Integer, List<User>> map = User.groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user + " ");
            }
            System.out.println("-----");
        }

        User notValidUser = new User("F", 19, "IKEA", "London");
    }
}
