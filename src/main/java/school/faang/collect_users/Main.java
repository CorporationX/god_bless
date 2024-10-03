package school.faang.collect_users;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var hobbies = Set.of("Soccer", "Gym", "Swimming");
        var otherHobbies = Set.of("Games", "Dancing");
        var users = List.of(
                new User(1, "Antony", 23, hobbies),
                new User(2, "Johny", 25, otherHobbies)
        );
        System.out.println(User.findHobbyLovers(users, hobbies));
        System.out.println(User.findHobbyLovers(users, otherHobbies));
    }
}
