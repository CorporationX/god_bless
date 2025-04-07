package school.faang.group_users_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final List<User> users = List.of(
                new User("Daniyal", 22, "Job", "Address"),
                new User("Dasha", 21, "Job", "Address"),
                new User("Lada", 24, "Job", "Address"),
                new User("Eva", 22, "Job", "Address"),
                new User("Masha", 28, "Job", "Address"),
                new User("Viktoria", 24, "Job", "Address")
        );

        final Map<Integer, List<User>> result = User.groupUsers(users);
        System.out.println(result);
    }
}
