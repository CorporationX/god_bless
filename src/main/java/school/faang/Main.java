package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alesha", 20, "google", "Tomsk"));
        users.add(new User("Sergey", 17, "pyaterochka", "Ekb"));
        users.add(new User("Andret", 17, "monetka", "Moskva"));
        users.add(new User("Maks", 20, "sitilink", "astrahan"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " -> Users: " + entry.getValue());
        }
    }
}
