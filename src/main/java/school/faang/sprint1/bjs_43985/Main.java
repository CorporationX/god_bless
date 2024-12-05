package school.faang.sprint1.bjs_43985;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(20, "Mike", 24, Set.of("sky", "read")),
                new User(43, "Nike", 19, Set.of("swim", "read")),
                new User(21, "Nino", 22, Set.of("dance", "sing"))
        );
        Set<String> hobbies = Set.of("read", "dance", "sing", "swim");

        Map<User, String> resultList = User.findHobbyLovers(users, hobbies);
        resultList.forEach((user, hobby) ->
                System.out.println(user + " -> " + hobby)
        );
    }
}
