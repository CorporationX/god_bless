package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : activities) {
                if (user.getActivities().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("reading", "swimming")));
        User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("running", "swimming")));
        User user3 = new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("cycling", "reading")));

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("swimming", "cycling"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        hobbyLovers.forEach((user, hobby) ->
                System.out.println("User: " + user.getName() + ", Hobby: " + hobby)
        );
    }

}
