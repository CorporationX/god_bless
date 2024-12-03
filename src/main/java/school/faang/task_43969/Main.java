package school.faang.task_43969;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.task_43969.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Misha", 28, Set.of("football", "volleyball")));
        users.add(new User(2L, "Denis", 28, Set.of("hockey", "football")));
        users.add(new User(3L, "Oleg", 23, Set.of("tennis", "swimming")));
        users.add(new User(4L, "Stas", 23, Set.of("football", "tennis")));
        users.add(new User(5L, "Nikita", 23, Set.of("swimming", "hockey")));
        users.add(new User(6L, "Oksana", 25, Set.of("basketball", "swimming")));
        users.add(new User(7L, "Alexander", 25, Set.of("football", "hockey", "tennis")));
        users.add(new User(8L, "Olga", 26, Set.of("swimming", "tennis", "volleyball")));
        Set<String> hobbies = Set.of("football", "hockey", "swimming");
        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        printAll(hobbyLovers);
    }

    public static void printAll(Map<User, String> hobbyLovers) {
        hobbyLovers.forEach((user, hobby) -> System.out.println(user + " -> Hobby: " + hobby));
    }
}
