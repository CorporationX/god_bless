package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Pavel", 19, Set.of("Reading", "Powerlifting", "Cooking"));
        User user2 = new User(2, "Maria", 45, Set.of("Hockey", "Programming", "Dishwashing"));
        User user3 = new User(3, "Oleg", 23, Set.of("Constructing", "Trading", "Cooking"));
        User user4 = new User(4, "Mikhail", 28, Set.of("Football", "Dishwashing", "Reading"));

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Set<String> activitiesToFind = Set.of("Reading", "Dancing", "Cooking");

        Map<User, String> result = User.findHobbyLovers(users, activitiesToFind);

        System.out.println("Users with matched activities:");
        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ", Activity: " + entry.getValue());
        }
    }
}
