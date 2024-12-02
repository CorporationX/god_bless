package Grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 20, "Uber", "Lenina 23"));
        users.add(new User("Victor", 24, "Amazon", "Kirova 75"));
        users.add(new User("Pavel", 25, "Ozon", "Central street 12"));
        users.add(new User("Masha", 22, "Google", "Energetikov 49"));
        users.add(new User("Leonid", 20, "Tinkoff", "Green street 0"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            System.out.println("Данные: " + entry.getValue());
        }
    }
}