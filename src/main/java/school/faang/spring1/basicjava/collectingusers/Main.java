package school.faang.spring1.basicjava.collectingusers;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("Reading", "Football", "Chess", "Swimming", "Cooking", "Skiing", "Yoga");

        User user1 = new User(1, "John", 25, Set.of("Reading", "Chess"));
        User user2 = new User(2, "Mary", 30, Set.of("Drawing", "Yoga"));
        User user3 = new User(3, "Alex", 28, Set.of("Hunting", "Fishing"));
        User user4 = new User(4, "Olivia", 22, Set.of("Cooking", "Aerobics", "Swimming"));

        List<User> users = List.of(user1, user2, user3, user4);
        System.out.println(User.findHobbyLovers(users, hobbies));
    }
}
