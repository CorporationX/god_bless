package SortByAge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Abror", 32, "Vention", "Tashkent"),
                new User("Dilnura", 2, "Vention", "Tashkent"),
                new User("Dilafroz", 32, "Vention", "Tashkent"),
                new User("Zarina", 1, "Vention", "Tashkent")
        );
        System.out.println(User.groupUsers(users));
    }
}
