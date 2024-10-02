package school.faang;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Gadzhi", 20, "google", "address"),
                new User("Ali", 20, "microsoft", "address"),
                new User("Maks", 20, "sber", "address"),
                new User("Anastasya", 13, "amazon", "address"),
                new User("Vlad", 13, "uber", "address"),
                new User("Andrey", 33, "meta", "address")
        );

        System.out.println(User.groupUsers(users));
    }
}
