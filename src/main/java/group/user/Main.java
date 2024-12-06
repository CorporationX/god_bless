package group.user;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Artur", 21, "Google", "Moscow");
        User user2 = new User("Ivan", 22, "Uber", "New York");
        User user3 = new User("Liza", 21, "Amazon", "London");

        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        System.out.println(User.groupUsers(usersList));
    }
}
