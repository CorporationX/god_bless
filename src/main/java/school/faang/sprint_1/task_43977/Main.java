package school.faang.sprint_1.task_43977;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.sprint_1.task_43977.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbyIvan = new HashSet<>();
        hobbyIvan.add("Dance");
        hobbyIvan.add("Painting");
        hobbyIvan.add("Cooking");
        hobbyIvan.add("Fishing");

        Set<String> hobbyMax = new HashSet<>();
        hobbyMax.add("Dance");
        hobbyMax.add("Golf");
        hobbyMax.add("Fishing");
        hobbyMax.add("Bowling");

        Set<String> hobbyAlex = new HashSet<>();
        hobbyAlex.add("Golf");
        hobbyAlex.add("Cooking");
        hobbyAlex.add("Knitting");
        hobbyAlex.add("Gardening");

        Set<String> test = new HashSet<>();
        test.add("Cooking");
        test.add("Fishing");
        test.add("Painting");

        User user1 = new User(1, "Ivan", 24, hobbyIvan);
        User user2 = new User(2, "Max", 34, hobbyMax);
        User user3 = new User(3, "Alex", 33, hobbyAlex);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        for (Map.Entry<User, String> entry : findHobbyLovers(users, test).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}