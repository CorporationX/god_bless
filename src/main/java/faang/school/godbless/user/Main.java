package faang.school.godbless.user;

import faang.school.godbless.user.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Ann", 27, "BMW", "Germany"),
                new User("Boris", 27, "Lidl", "Germany"),
                new User("Gerda", 37, "NeoX", "Germany"),
                new User("Ivan", 37, "Aldi", "Germany"),
                new User("Karin", 27, "Telekom", "Germany"),
                new User("Isabella", 37, "Telekom", "Germany"),
                new User("Andrew", 37, "BMW", "Germany")
        );

        System.out.println(User.groupUsers(users));
    }
}
