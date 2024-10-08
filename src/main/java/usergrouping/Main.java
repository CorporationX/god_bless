package usergrouping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> testUsers = new ArrayList<>();
        testUsers.add(new User("user1", 17, "", ""));
        testUsers.add(new User("user2", 17, "", ""));
        testUsers.add(new User("user3", 16, "", ""));
        testUsers.add(new User("user4", 18, "", ""));
        System.out.println(User.groupUsers(testUsers));
    }
}
