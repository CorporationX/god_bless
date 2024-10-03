package school.faang.usercollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<String> HOBBIES = Set.of("Programming", "Skiing",
            "Gaming", "Drifting", "Hiking", "Watching Movies");

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Alex", 25,
                        Set.of("Programming", "Gaming", "Watching Movies")),
                new User(2, "Vlad", 25,
                        Set.of("Skiing", "Gaming", "Watching Movies")),
                new User(3, "Kirill", 25,
                        Set.of("Drifting", "Gaming", "Watching Movies")),
                new User(4, "Mifodiy", 25,
                        Set.of("Gaming", "Hiking", "Watching Movies")),
                new User(5, "Sauron", 25,
                        Set.of("Creating Rings", "Manipulating", "Giant eyes"))
        );

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, HOBBIES);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
