package school.faang.usergrouping;

import java.util.List;
import java.util.Map;

import static school.faang.usergrouping.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Nikolay", 18, "ya", "Street1");
        User user2 = new User("Sergay", 18, "T-bank", "Street2");
        User user3 = new User("Alex", 20, "ya", "Street3");
        User user4 = new User("Zaur", 19, "ya", "Street4");
        List<User> users = List.of(user1, user2, user3, user4);

        Map<Integer, List<User>> userGroupings = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : userGroupings.entrySet()) {
            System.out.println(entry.getKey() + " age Users: " + entry.getValue());
        }
    }
}
