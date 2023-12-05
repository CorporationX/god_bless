package faang.school.godbless;

import faang.school.godbless.BJS2_397.User;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {

        User user1 = new User("Edisolt", 23);
        User user4 = new User("Vlad", 40);
        User user2 = new User("Alex", 90);
        User user3 = new User("Faang", 1);
        User user5 = new User("one more Vlad", 40);

        List<User> userList = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> userMap = User.groupUsers(userList);

        System.out.println(userMap);
    }
}
