package groupUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Коля", 150, "Google", "London"));
        users.add(new User("Толя", 130, "Google", "London"));
        users.add(new User("Моля", 130, "Google", "London"));
        users.add(new User("Ноля", 150, "Google", "London"));
        users.add(new User("Боля", 150, "Google", "London"));
        users.add(new User("Оля", 110, "Google", "London"));
        users.add(new User("Зоя", 250, "Google", "London"));
        users.add(new User("Поля", 104, "Google", "London"));

        User.groupUsers(users);
    }
}
