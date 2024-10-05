package SortByAge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = List.of(
                    new User("Abror", 32, "Uber", "New York"),
                    new User("Dilnura", 22, "Amazon", "London"),
                    new User("Dilafroz", 32, "Google", "Amsterdam"),
                    new User("Zarina", 19, "Uber", "London")
            );
            System.out.println(User.groupUsers(users));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
