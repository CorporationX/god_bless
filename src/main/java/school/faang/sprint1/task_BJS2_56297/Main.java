package school.faang.sprint1.task_BJS2_56297;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("sport", "coding", "swimming");
        List<User> users = List.of(
                new User(0, "Ivan", 32, Set.of("read", "sport", "anime")),
                new User(1, "Petya", 20, Set.of("sport", "play")),
                new User(2, "Kolya", 12, Set.of("coding", "smoking")),
                new User(3, "Andrey", 42, Set.of("read", "anime", "smoking")));

        System.out.println(User.findHobbyLovers(users, hobbies));
        System.out.println(User.findHobbyLovers(new ArrayList<>(), hobbies));
        System.out.println(User.findHobbyLovers(users, new HashSet<>()));
        System.out.println(User.findHobbyLovers(new ArrayList<>(), new HashSet<>()));
    }
}
