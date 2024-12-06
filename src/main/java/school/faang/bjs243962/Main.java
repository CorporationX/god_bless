package school.faang.bjs243962;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>() {
            {
                add(new User(1, "User1", 19,
                        Stream.of("Sports", "Music", "Reading").toList()));
                add(new User(2, "User2", 21,
                        Stream.of("Gaming", "Gambling").toList()));
                add(new User(3, "User3", 23,
                        Stream.of("Gaming", "Music").toList()));
                add(new User(4, "User4", 31,
                        Stream.of("Hiking", "Gambling").toList()));
            }
        };

        List<String> activities = List.of("Gaming", "Music");

        User.findHobbyLovers(users, activities);
    }
}
