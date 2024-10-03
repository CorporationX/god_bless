package school.faang.BJS2_31500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 30, new HashSet<>(List.of("Football", "Movies", "Travel"))));
        users.add(new User("Catherine", 28, new HashSet<>(List.of("Movies", "Drawing", "Swimming"))));
        users.add(new User("Michael", 25, new HashSet<>(List.of("Football", "Tennis", "Travel"))));
        users.add(new User("Irina", 35, new HashSet<>(List.of("Swimming", "Yoga", "Travel"))));
        users.add(new User("Paul", 27, new HashSet<>(List.of("Football", "Cooking", "Tennis"))));
        users.add(new User("Maria", 23, new HashSet<>(List.of("Movies", "Drawing", "Yoga"))));
        users.add(new User("Sergey", 29, new HashSet<>(List.of("Video Games", "Travel"))));
        users.add(new User("Natalie", 32, new HashSet<>(List.of("Swimming", "Tennis", "Photography"))));
        users.add(new User("Dmitry", 31, new HashSet<>(List.of("Football", "Swimming", "Tennis"))));
        users.add(new User("Elena", 26, new HashSet<>(List.of("Travel", "Cooking", "Photography"))));

        // Создание набора увлечений для сравнения
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Tennis"));

        Map<User, Set<String>> usersHobbiesIntersection = User.findHobbyLovers(users, hobbies);
        usersHobbiesIntersection.forEach((user, userHobbies) ->
                System.out.println(user + ": " + String.join(", ", userHobbies))
        );
    }
}
