package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class TestUser {

    public static void main(String[] args) {
        User user1 = new User("Gosha", 19, "Amazon", "London");
        User user2 = new User("Leha", 33, "Google", "New York");
        User user3 = new User("Vlad", 18, "Uber", "Amsterdam");
        List<User> testList = List.of(user1, user2, user3);
        System.out.println(User.groupUsers(testList));
    }

}
