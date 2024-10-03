package groupUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Коля", 15, "Amazon", "USA"));
        users.add(new User("Толя", 13, "Amazon", "USA"));
        users.add(new User("Моля", 13, "Amazon", "USA"));
        users.add(new User("Ноля", 15, "Amazon", "USA"));
        users.add(new User("Боля", 15, "Amazon", "USA"));
        users.add(new User("Оля", 11, "Amazon", "USA"));
        users.add(new User("Зоя", 25, "Amazon", "USA"));
        users.add(new User("Поля", 104, "Amazon", "USA"));

        User.groupUsers(users);
    }
}
