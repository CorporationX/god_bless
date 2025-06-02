package school.faang.bjs2_79159;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, Arrays.asList("Reading", "Hiking", "Swimming"));
        User user2 = new User(2, "Bob", 30, Arrays.asList("Cooking", "Gaming"));
        User user3 = new User(3, "Charlie", 22, Arrays.asList("Hiking", "Gaming", "Music"));
        User user4 = new User(4, "Diana", 28, Arrays.asList("Knitting", "Swimming"));
        User user5 = new User(5, "Eve", 31, null);  // test null activities

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5);
        List<String> activitiesToFind = Arrays.asList("Swimming", "Gaming");

        Map<User, String> matches = User.findHobbyLovers(userList, activitiesToFind);

        System.out.println("Users and first matching activities:");
        matches.forEach((user, activity) -> System.out.println(user.getName() + " matched with activity: " + activity));
    }
}
