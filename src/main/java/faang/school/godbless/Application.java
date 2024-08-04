package faang.school.godbless;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        User user1 = new User("Emily", 28);
        User user2 = new User("Michael", 35);
        User user3 = new User("Sophia", 22);
        User user4 = new User("James", 28);
        User user5 = new User("Olivia", 35);

        ArrayList<User> usersList = new ArrayList<>();
        Collections.addAll(usersList, user1, user2, user3, user4, user5);

        System.out.println(User.groupUsers(usersList));

    }
}