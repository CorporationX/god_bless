package school.faang.throne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneMain {
    public static void main(String[] args) {
        Map<String, Integer> roles = new HashMap<>();
        roles.put("лорд", 1);
        roles.put("рыцарь", 3);
        roles.put("маг", 1);

        House house = new House(roles);
        List<User> users = List.of(
                new User("Игрок 1", house),
                new User("Игрок 2", house),
                new User("Игрок 3", house),
                new User("Игрок 4", house),
                new User("Игрок 5", house)
        );

       for (User user : users) {
           new Thread(user).start();
       }
    }
}
