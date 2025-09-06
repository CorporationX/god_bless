package school.faang.bjs2_85515;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User pavel = new User("Pavel", 29, "Alt", "Surgut");
        User denis = new User("Denis", 29, "Alt", "Surgut");
        User egor = new User("Egor", 17, "Alt", "Surgut");
        User nikita = new User("Nikita", 26, "Alt", "Surgut");
        User ksenia = new User("Ksenia", 27, "Alt", "Surgut");

        users.add(pavel);
        users.add(denis);
        users.add(egor);
        users.add(nikita);
        users.add(ksenia);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        System.out.println(groupedUsers);
    }
}
