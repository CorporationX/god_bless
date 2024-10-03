package school.faang.group_user_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var users = List.of(
                new User("Sam", 18, "Google", "Washington DC"),
                new User("Ban", 21, "Amazon", "Miami"),
                new User("Keanu", 18, "Netflix", "California"),
                new User("John", 40, "Microsoft", "Texas")
        );

        System.out.println(User.groupUser(users, 18));
    }
}
