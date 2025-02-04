package school.faang.usergrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        User tolik = new User("Tolik", 30, "McDonald's", "20, Lesnaya street");
        User tom = new User("Tom", 30, "Stars coffee", "10, Butirka street");
        User kolyan = new User("Kolyan", 20, "Amazon", "10, 5th Avenue");
        User sasha = new User("Sasha", 25, "Yandex", "11, Tverskaya street");

        List<User> users = new ArrayList<>();
        users.add(tolik);
        users.add(tom);
        users.add(kolyan);
        users.add(sasha);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> usersByAge : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + usersByAge.getKey() + " - Пользователи: ");
            for (User user : usersByAge.getValue()) {
                System.out.println(user.getName());
            }
        }
    }
}
