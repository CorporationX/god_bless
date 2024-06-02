package faang.school.godbless.group_users_by_age;

import java.util.Arrays;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User("George", 21, "OPS", "Yonge St. 5775");
        User user2 = new User("Ethan", 22, "NoblKids", "Bergeron Center");

        Map<Integer, User> map = User.groupUsers(Arrays.asList(user2, user1));

        System.out.println(map);
        System.out.println(map.get(21));
    }
}