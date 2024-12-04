package school.faang.task_43959;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Dzmitry", 19, "Nokia", "Edwarda Wittiga 8"));
        users.add(new User("Aliaksandr", 19, "Epam", "Tramwajowa 4"));
        users.add(new User("Timofey", 20, "Visa", "Krzywoustego 12"));

        System.out.println(User.groupUsers(users));
    }
}
