package school.faang;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> jakeHobbies = new HashSet<>(Set.of("hobby horsing", "box", "swimming"));
        HashSet<String> mikeHobbies = new HashSet<>(Set.of("water polo", "hiking", "dnd"));

        User jake = new User(1, "Jake", 23, jakeHobbies);
        User mike = new User(2, "Mike", 40, mikeHobbies);
        List<User> users = new ArrayList<>();

        users.add(mike);
        users.add(jake);

        HashSet<String> targetActivities = new HashSet<>(Set.of("box", "swimming"));
        Map<User, String> hobbyLovers = jake.findHobbyLovers(users, targetActivities);
        System.out.println(hobbyLovers.toString());
    }
}
