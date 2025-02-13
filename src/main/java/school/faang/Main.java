package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();
        users.add(new User("Alex", 20, "Facebook", "London"));
        users.add(new User("Ivan", 25, "Amazon", "Berlin"));
        users.add(new User("Pavel", 20, "Google", "Paris"));
        users.add(new User("Kate", 10, "VKontakte", "Dubai"));

        var map = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            var names = new ArrayList<String>();
            entry.getValue().stream().map(User::name).forEach(names::add);
            System.out.printf("%d: %s%n", entry.getKey(), String.join(", ", names));
        }
    }
}
