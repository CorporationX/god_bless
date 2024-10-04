package groupUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>(List.of(
            new User("Коля", 15, "Amazon", "USA"),
            new User("Толя", 13, "Amazon", "USA"),
            new User("Моля", 13, "Amazon", "USA"),
            new User("Ноля", 15, "Amazon", "USA"),
            new User("Боля", 15, "Amazon", "USA"),
            new User("Оля", 11, "Amazon", "USA"),
            new User("Зоя", 25, "Amazon", "USA"),
            new User("Поля", 104, "Amazon", "USA")
        ));

        User.groupUsers(users);
    }
}
