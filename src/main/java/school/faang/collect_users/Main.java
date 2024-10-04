package school.faang.collect_users;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Gadzhi", 18, "HobbyHorsing"),
                new User(2, "Vlad", 30, "Prog"),
                new User(3, "Ali", 22, "Volleyball"),
                new User(4, "Vanya", 24, "Box")
        );

        Set<String> activity = Set.of(
                new String("game"),
                new String("football"),
                new String("Box"),
                new String("HobbyHorsing")
        );

        System.out.println(User.findHobbyLovers(users, activity));

    }
}