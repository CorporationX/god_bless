package faang.school.godbless.group_users_by_age;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User("George", 21, "OPS", "Yonge St. 5775");
        User user2 = new User("Ethan", 22, "NoblKids", "Bergeron Center");
        User user3 = new User("Someone else", 21, "OPS", "Yonge St. 5775");

        Map<Integer, List<User>> map = User.groupUsers(Arrays.asList(user2, user1, user3));

        System.out.println(map);
        System.out.println(map.get(21));
    }
}