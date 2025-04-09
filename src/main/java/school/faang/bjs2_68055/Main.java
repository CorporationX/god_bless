package school.faang.bjs2_68055;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Miras", 25, Set.of("reading", "running", "yoga"));
        User u2 = new User(2, "Ivan", 30, Set.of("chess", "yoga"));
        User u3 = new User(3, "Max", 22, Set.of("painting", "swimming"));

        List<User> users = List.of(u1, u2, u3);
        Set<String> hobbies = Set.of("yoga", "swimming");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves: " + entry.getValue());
        }
    }
}