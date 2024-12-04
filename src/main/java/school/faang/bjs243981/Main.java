package school.faang.bjs243981;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(123, "Nikolay", 25, List.of("Football", "Chess", "Book", "Math"));
        User user2 = new User(332, "Anna", 24, List.of("Swimming", "Drawing", "Book", "Volleyball"));
        User user3 = new User(132, "Dmitriy", 22, List.of("Volleyball", "Football", "Computer game", "Math"));
        User user4 = new User(913, "Elizaveta", 19, List.of("Drawing", "Volleyball"));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Set<String> setHobby = Set.of("Football", "Chess", "Book", "Math");

        Map<User, String> containsUserHobby = User.findHobbyLovers(users, setHobby);
        containsUserHobby.forEach((user, string) -> {
            System.out.println(user + " : " + string);
        });
    }
}
