package school.faang.BJS2_43989;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activities = Set.of(
                "reading",
                "running",
                "swimming",
                "hiking",
                "singing");

        Set<String> activitiesBob = Set.of(
                "running",
                "singing",
                "hiking");

        Set<String> activitiesAlice = Set.of(
                "singing",
                "running");

        User bob = new User(123L, "Bob", 25, activitiesBob);
        User alice = new User(124L, "Alice", 22, activitiesAlice);

        Map<User, String> hobbyLoversByUser = bob.findHobbyLovers(Arrays.asList(bob, alice), activities);

        System.out.println(hobbyLoversByUser);
    }
}
