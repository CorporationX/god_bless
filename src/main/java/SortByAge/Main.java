package SortByAge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Abror", 32, "Vention", "Tashkent");
        User user2 = new User("Dilnura", 2, "Vention", "Tashkent");
        User user3 = new User("Dilafroz", 32, "Vention", "Tashkent");
        User user4 = new User("Zarina", 1, "Vention", "Tashkent");

        List<User> users = List.of(user1, user2, user3, user4);
        System.out.println(User.groupUsers(users));
    }
}
