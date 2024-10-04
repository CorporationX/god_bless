package school.faang.t11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Set<String> HOBBIES = new HashSet<>(List.of("Running", "Cycling", "Eating"));
    public static final List<User> USER_LIST = new ArrayList<>();

    public static void main(String[] args) {

        User userOne = new User(1, "Igor", 18, Set.of("Running", "Cycling"));
        User userTwo = new User(1, "Vasya", 26, Set.of("Mining", "Tapping"));
        User userTree = new User(1, "Tasya", 20, Set.of("Eating", "Cycling"));

        USER_LIST.add(userOne);
        USER_LIST.add(userTwo);
        USER_LIST.add(userTree);

        Map<User, String> usersActivities = User.findHobbyLovers(USER_LIST, HOBBIES);
        usersActivities.forEach((user, userHobby) -> System.out.println(user + ": " + userHobby));
    }
}