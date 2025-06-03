package school.faang.bjs2_79159;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(1, "Alice", 25, Set.of("Reading", "Hiking", "Swimming")),
                new User(2, "Bob", 30, Set.of("Cooking", "Gaming")),
                new User(3, "Charlie", 22, Set.of("Hiking", "Gaming", "Music")),
                new User(4, "Diana", 28, Set.of("Knitting", "Swimming")),
                new User(5, "Eve", 31, null)
        );
        List<String> activitiesToFind = List.of("Swimming", "Gaming");

        Map<User, String> matches = User.findHobbyLovers(userList, activitiesToFind);

        System.out.println("Users and first matching activities:");
        matches.forEach((user, activity) -> System.out.println(user.getName() + " matched with activity: " + activity));
    }
}
