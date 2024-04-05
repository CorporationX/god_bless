package users_registartion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("John", 33, "Google", "New York"));
        usersList.add(new User("Bob", 26, "Amazon", "Berlin"));
        usersList.add(new User("Amely", 19, "Yandex", "Saint-Petersburg"));
        usersList.add(new User("Maria", 26, "Ozon", "Moscow"));
        usersList.add(new User("Sarah", 33, "Apple", "California"));
        usersList.add(new User("Petr", 19, "Yandex", "Moscow"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(usersList).entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
