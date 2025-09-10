package school.faang.bjs2_85602;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ваня", 28, "Faang", "FaangSchool"));
        users.add(new User("Аня",  32, "Faang", "FaangSchool"));
        users.add(new User("Леша", 25, "Faang", "FaangSchool"));
        users.add(new User("Вика", 25, "Faang", "FaangSchool"));

        Map<Integer, List<User>> groupUser = User.groupUsers(users);
        System.out.println(groupUser);
    }
}
