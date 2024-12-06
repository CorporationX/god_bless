package school.faang.sprint_1.task_collectusersbjs2n44013;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(
                new User(1, "Tom", 24, Set.of("tennis", "football")),
                new User(2, "Ann", 25, Set.of("carting", "football")),
                new User(3, "John", 26, Set.of("hockey", "literball"))
        );

        Set<String> set = Set.of("tennis", "football", "carting");
        Map<User, String> map = User.findHobbyLovers(usersList, set);

        for (Map.Entry<User, String> user : map.entrySet()) {
            System.out.printf("%s - with activity -  %s \n", user.getKey().getName(), user.getValue());
        }
    }
}
