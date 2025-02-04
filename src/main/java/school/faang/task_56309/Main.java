package school.faang.task_56309;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("reading", "gaming")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("sports", "music")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("gaming", "cooking")));

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> hobbies = new HashSet<>(Arrays.asList("gaming", "traveling"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            User user = entry.getKey();
            String hobby = entry.getValue();
            System.out.println(":User  " + user.getName() + ", Hobby: " + hobby);
        }
    }
}
