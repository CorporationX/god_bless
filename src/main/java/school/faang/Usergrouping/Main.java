package school.faang.Usergrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.Usergrouping.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Nikolay", 18, "ya", "Street1");
        User user2 = new User("Sergay", 18, "T-bank", "Street2");
        User user3 = new User("Alex", 20, "ya", "Street3");
        User user4 = new User("Zaur", 19, "ya", "Street4");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Map<Integer, List<User>> userGroupings = groupUsers(users);
        System.out.println(userGroupings);
    }
}
