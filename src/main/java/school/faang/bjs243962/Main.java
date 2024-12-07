package school.faang.bjs243962;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Set<User> users = new HashSet<>();
        users.add(new User(1, "User1", 19,
                Stream.of("Sports", "Music", "Reading").collect(Collectors.toSet())));
        users.add(new User(2, "User2", 21,
                Stream.of("Gaming", "Gambling").collect(Collectors.toSet())));
        users.add(new User(3, "User3", 23,
                Stream.of("Gaming", "Music").collect(Collectors.toSet())));
        users.add(new User(4, "User4", 31,
                Stream.of("Hiking", "Gambling").collect(Collectors.toSet())));

        Set<String> activities = new HashSet<>();
        activities.add("Gaming");
        activities.add("Music");

        User.findHobbyLovers(users, activities);
    }
}
