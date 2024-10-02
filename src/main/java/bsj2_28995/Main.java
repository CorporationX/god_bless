package bsj2_28995;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Jack", 22, "Spotify", "Zelenograd"));
        users.add(new User("John", 19, "Google", "Krasnoyarsk"));
        users.add(new User("Jess", 22, "Yandex", "New-York"));
        users.add(new User("Jane", 19, "Sber", "Prague"));
        users.add(new User("Sam", 18, "Yandex", "Moscow"));

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);

        System.out.println(usersByAge);
    }
}
