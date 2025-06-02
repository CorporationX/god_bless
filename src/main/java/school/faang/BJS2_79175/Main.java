package school.faang.BJS2_79175;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("Tom", 55, "Amazon", "Pushkina 1");
        User user2 = new User("Genadiy", 19, "Yandex", "Kapustovo 10");
        User user3 = new User("Sam", 24, "Yandex", "Pobeda 22");
        User user4 = new User("Vlad", 32, "Sberbank", "Lenina 12");

        List.of(user1, user2, user3, user4).forEach(user -> users.add(user));
        System.out.println(User.groupUsers(users));
    }
}
