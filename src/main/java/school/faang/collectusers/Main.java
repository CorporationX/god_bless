package school.faang.collectusers;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var users = Set.of(
                new User("user1", "Danil", 25, Set.of("yoga", "swimming", "walking", "reading")),
                new User("user2", "Max", 27, Set.of("running", "camping", "bikes", "barbecue")),
                new User("user3", "Amelia", 22, Set.of("yoga", "shopping", "movies", "cooking")),
                new User("user4", "Julia", 23, Set.of("fitness", "travelling", "singing", "camping"))
        );
        var hobbies = Set.of("yoga", "reading");
        var hobbyByUser = User.findHobbyLovers(users, hobbies);
        for (var entry : hobbyByUser.entrySet()) {
            System.out.println(entry.getKey() + " likes " + entry.getValue());
        }
    }
}
