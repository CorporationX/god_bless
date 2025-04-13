package school.faang.user_group_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Emy", 18, "somewhere", "somewhere"),
                new User("Penny", 18, "somewhere", "somewhere"),
                new User("Bernadette", 19, "somewhere", "somewhere"),
                new User("Leslie Winkle", 25, "somewhere", "somewhere"));
        Map<Integer, List<User>> usersGroupByAge = User.groupUsers(users);
        System.out.println(usersGroupByAge);
    }
}
