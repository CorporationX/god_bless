package BJS2_56384;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String READING = "Reading";
    private static final String PROGRAMMING = "Programming";
    private static final String GAMING = "Gaming";
    private static final String SPORT = "Sport";
    private static final String COOKING = "Cooking";

    public static void main(String[] args) {
        User gor = new User(1, "Gor", 26, Set.of(PROGRAMMING, GAMING, SPORT));
        User ani = new User(2, "Ani", 23, Set.of(READING, COOKING, SPORT));
        User mariam = new User(3, "Mariam", 29, Set.of(PROGRAMMING, GAMING, COOKING));
        User karen = new User(4, "Karen", 28, Set.of(READING, GAMING, SPORT));

        List<User> users = List.of(gor, ani, mariam, karen);
        Set<String> hobbies = Set.of(GAMING, SPORT);

        Map<User, String> findHobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : findHobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}
