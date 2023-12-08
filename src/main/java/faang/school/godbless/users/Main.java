package faang.school.godbless.users;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("", 27, "Uber", "London"));
        User.groupUsers(users);
    }
}
