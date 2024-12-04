package school.faang.bjs243983;


import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User(1L, "Solih", 20, Set.of("IT", "CS2", "Book"));
        User user1 = new User(2L, "John", 34, Set.of("Football", "Dota", "Book"));
        User user2 = new User(3L, "Steve", 23, Set.of("Music", "Chef", "Play"));
        User user3 = new User(4L, "Artom", 65, Set.of("IT", "CS2", "Movie"));

        Set<User> users = Set.of(user, user1, user2, user3);
        Set<String> activities = Set.of("IT", "CS2", "Book");

        Map<User, String> result = user.findHobbyLovers(users, activities);

        result.forEach((myUser, myActivity) -> {
            System.out.println(myUser.getName() + " : " + myActivity);
        });

    }
}
