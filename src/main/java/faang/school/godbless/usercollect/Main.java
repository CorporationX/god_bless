package faang.school.godbless.usercollect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", 25, Set.of("Reading", "Running")));
        users.add(new User(2, "Alice", 30, Set.of("Swimming", "Painting")));
        users.add(new User(3, "Bob", 22, Set.of("Cycling", "Gaming")));
        Map<User, String> hobbyLovers = findHobbyLovers(users, Set.of("Gaming", "Swimming"));
        for (var entry : hobbyLovers.entrySet()) {
            System.out.println(String.format("User: %s, Hobby: %s", entry.getKey().getName(), entry.getValue()));
        }
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (var user : users) {
            for (var activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
