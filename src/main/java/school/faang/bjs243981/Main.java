package school.faang.bjs243981;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(123, "Nikolay", 25, List.of("Football", "Chess", "Book", "Math")),
                new User(332, "Anna", 24, List.of("Swimming", "Drawing", "Book", "Volleyball")),
                new User(132, "Dmitriy", 22, List.of("Volleyball", "Football", "Computer game", "Math")),
                new User(913, "Elizaveta", 19, List.of("Drawing", "Volleyball")));

        Set<String> setHobby = Set.of("Football", "Chess", "Book", "Math");

        Map<User, String> containsUserHobby = User.findHobbyLovers(users, setHobby);
        containsUserHobby.forEach((user, hobby) -> {
            System.out.println(user + " : " + hobby);
        });
    }
}
