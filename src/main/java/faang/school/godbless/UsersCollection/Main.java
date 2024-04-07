package faang.school.godbless.UsersCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "David", 23, Set.of("Drawing", "Football", "Dancing"));
        User user2 = new User(2, "Alice", 17, Set.of("Meditation", "Walking", "Movies"));
        User user3 = new User(3, "Derek", 34, Set.of("Writing", "Drawing"));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Set<String> activitiesToSearch = new HashSet<>();
        activitiesToSearch.add("Drawing");
        activitiesToSearch.add("Walking");

        Map<User, String> hobbyLoversMap = User.findHobbyLovers(users, activitiesToSearch);

        User.printHobbyLovers(hobbyLoversMap);

    }
}
