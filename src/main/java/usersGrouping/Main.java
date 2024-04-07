package usersGrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 33, "Google", "London"));
        users.add(new User("Bob", 26, "Amazon", "Berlin"));
        users.add(new User("Amely", 19, "Yandex", "Saint-Petersburg"));
        users.add(new User("Maria", 26, "Ozon", "Moscow"));
        users.add(new User("Sarah", 33, "Apple", "California"));
        users.add(new User("Petr", 19, "Yandex", "Moscow"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
