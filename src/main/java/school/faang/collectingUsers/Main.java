package school.faang.collectingUsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> jakeHobbies = Set.of("hobby horsing", "box", "swimming");
        Set<String> mikeHobbies = Set.of("water polo", "hiking", "dnd");

        User jake = new User(1, "Jake", 23, jakeHobbies);
        User mike = new User(2, "Mike", 40, mikeHobbies);
        List<User> users = new ArrayList<>();

        users.add(mike);
        users.add(jake);

        Set<String> targetActivities = Set.of("box", "swimming");
        Map<User, String> hobbyLovers = jake.findHobbyLovers(users, targetActivities);
        System.out.println(hobbyLovers.toString());
    }
}
