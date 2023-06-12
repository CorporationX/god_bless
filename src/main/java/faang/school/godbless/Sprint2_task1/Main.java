package faang.school.godbless.Sprint2_task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("name1", 25, "X", "Palo Alto");
        User user2 = new User("name2", 25, "Y", "Chicago");
        User user3 = new User("name3", 35, "Z", "Miami");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Map<Integer, List<User>> groupMap = User.groupUsers(userList);
        System.out.println(groupMap);
    }
}
