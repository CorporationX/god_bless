package bjs2_2120;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Pavel", 21, "Yandex", "Centralnay street");
        User user2 = new User("Leonid", 32, "Mail", "Lenina street");
        User user3 = new User("Jo", 21, "Google", "Undefined st.");
        List<User> users = new ArrayList<>() {{
            add(user1);
            add(user2);
            add(user3);
        }};
        System.out.println(User.groupUsers(users));
    }
}
