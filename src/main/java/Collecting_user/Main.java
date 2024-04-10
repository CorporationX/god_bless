package Collecting_user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alesha", 20, Set.of("Photography", "Hiking", "Yoga")));
        users.add(new User(2, "Oleja", 25, Set.of("Writing", "Traveling", "IT")));
        users.add(new User(3, "Maksim", 30, Set.of("Fishing", "Gaming")));
        users.add(new User(4, "Victor", 33, Set.of("Running", "Painting", "Literature")));
        users.add(new User(5, "Anna", 22, Set.of("Dancing", "Painting", "Cycling")));
        users.add(new User(6, "Lidiya", 28, Set.of("Cooking", "Dancing", "IT", "Football")));

        for (Map.Entry<User, String> entry : User.findHobbyLovers(users, Set.of("Literature", "Football", "IT")).entrySet()) {
            System.out.println("User: " + entry.getKey());
            System.out.println("Activity – " + entry.getValue());
        }
    }
}
