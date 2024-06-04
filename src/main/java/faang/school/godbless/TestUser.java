package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class TestUser {

    public static void main(String[] args) {
        User user1 = new User("Alex", 15, "Google", "A");
        User user2 = new User("Leha", 15, "Google", "A");
        User user3 = new User("Vlad", 18, "Google", "A");
        List<User> testList = List.of(user1, user2, user3);
        System.out.println(User.groupUsers(testList));
    }

}
