package user.registration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        checkUserCreation("", 24, "Google", "New York");
        checkUserCreation("Kolya", 17, "Amazon", "London");
        checkUserCreation("Katya", 21, "Yandex", "Amsterdam");
        checkUserCreation("Slava", 24, "Google", "Montreal");
        checkUserCreation("", 15, "Kaspersky", "Moscow");
        checkUserCreation("Sveta", 25, "Uber", "Amsterdam");
        var users = List.of(
                new User("Misha", 24, "Google", "New York"),
                new User("Katya", 21, "Uber", "Amsterdam"),
                new User("Petya", 21, "Google", "New York"),
                new User("Lilya", 24, "Google", "New York"));
        User.groupUsers(users).forEach((k, v) -> {
            System.out.println(k);
            v.forEach(user -> System.out.println("    " + user));
        });
    }

    private static void checkUserCreation(String name, int age, String workPlace, String address) {
        try {
            new User(name, age, workPlace, address);
            System.out.println("User created!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
