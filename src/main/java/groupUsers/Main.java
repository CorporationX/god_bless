package groupUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>(List.of(
            new User("Коля", 150, "Google", "London"),
            new User("Толя", 130, "Google", "London"),
            new User("Моля", 130, "Google", "London"),
            new User("Ноля", 150, "Google", "London"),
            new User("Боля", 150, "Google", "London"),
            new User("Оля", 110, "Google", "London"),
            new User("Зоя", 250, "Google", "London"),
            new User("Поля", 104, "Google", "London")
        ));

        User.groupUsers(users);
    }
}
