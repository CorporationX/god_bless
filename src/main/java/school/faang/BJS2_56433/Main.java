package school.faang.BJS2_56433;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Artur", 21, "PlaceOne", "AddressOne"),
                new User("Timur", 34, "PlaceOne", "AddressOne"),
                new User("Ernar", 27, "PlaceTwo", "AddressTwo"),
                new User("Anna", 21, "PlaceTwo", "AddressTwo"),
                new User("Sofia", 25, "PlaceOne", "AddressOne")
        );

        User.groupUsers(users).forEach((age, user) -> {
            System.out.println(age + ": " + user);
        });
    }

}