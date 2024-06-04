package BJS2_7140;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Alex", 19, Set.of("swimming", "kachalka", "dancing")),
                new User(2, "YaroSlave", 20, Set.of("LOL", "priora", "kachalka")),
                new User(3, "Dima", 20, Set.of("sleeping","eda", "kachalka"))
        );
        Set<String> activities = Set.of("kachalka", "priora", "swimming", "sleeping");

        User.findHobbyLovers(users, activities)
                .forEach((key, value) ->
                        System.out.println("User:  " + key + " \nactivity: " + value + "\n"));
    }
}