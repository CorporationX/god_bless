package school.faang.collectingusers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        User user1 = new User(1, "Alice", 25, List.of("chess", "swimming", "reading"));
        User user2 = new User(2, "Bob", 30, List.of("football", "cooking"));
        User user3 = new User(3, "Cara", 22, List.of("chess", "tennis"));
        User user4 = new User(4, "Dave", 28, null);

        List<User> users = List.of(user1, user2, user3, user4);

        List<String> activities = List.of("football", "basketball", "swimming");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            User user = entry.getKey();
            String matchedActivity = entry.getValue();
            logger.info("{} (id = {}) → {}", user.getName(), user.getId(), matchedActivity);
        }
    }
}
