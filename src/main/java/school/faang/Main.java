package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] argc) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Pave", 24, "Google", "London"));
        users.add(new User("Alex", 29, "Apple", "Apple Park Way"));
        users.add(new User("Dima", 27, "Amazon", "Berlin"));
        users.add(new User("Dima", 24, "Amazon", "Berlin"));
        users.add(new User("Smith", 29, "Yandex", "Moscow"));

        Map<Integer, List<User>> usersMap  = groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : usersMap.entrySet()) {
            System.out.println( "Возраст: " +
                    entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.getName());
            }
        }
    }
}
