package faang.school.godbless.GroupingUsers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("TestName", 15, "TestJob", "TestAddress");
        User user2 = new User("TestName", 15, "TestJob", "TestAddress");
        User user3 = new User("TestName", 10, "TestJob", "TestAddress");
        User user4 = new User("TestName", 10, "TestJob", "TestAddress");
        User user5 = new User("TestName", 15, "TestJob", "TestAddress");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        System.out.println(User.groupUsers(users));
    }
}
