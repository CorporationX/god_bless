package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("User1", 12, "", "");
        User user2 = new User("User2", 15, "", "");
        User user3 = new User("User3", 5, "", "");
        User user4 = new User("User4", 12, "", "");
        User user5 = new User("User5", 64, "", "");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        System.out.println(User.groupUsers(users));
    }
}
