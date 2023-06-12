package Grouping_by_age;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Sergey", 19, "Netflix", "Kirova 2");
        User user2 = new User("Viktor", 19, "Yandex", "Mira 3");
        User user3 = new User("Andrew", 20, "McDon", "Lenina 4");
        User user4 = new User("Bika", 24, "KFC", "Matrosova 5");
        User user5 = new User("Alex", 12, "SpaceX", "Marksa 6");
        List<User> userList = List.of(user1, user2, user3, user4, user5);
        System.out.println(User.groupUsers(userList));
    }
}
