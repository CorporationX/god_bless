package school.faang.task_44017;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Vasya", 12, Set.of("Sport", "Learning", "Hiking"));
        User secondUser = new User(2, "Petya", 12, Set.of("Diving", "Learning", "Hiking"));

        Map<User, String> result = user.findHobbyLovers(List.of(user, secondUser), Set.of("Diving"));
        System.out.println(result);
        System.out.println();

        Map<User, String> secondResult = user.findHobbyLovers(List.of(user, secondUser), Set.of("Diving", "Hiking"));
        System.out.println(secondResult);
    }
}
