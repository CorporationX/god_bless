package school.faang.collect_users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set firstSet = new HashSet();
        firstSet.add("Football");

        Set secondSet = new HashSet();
        secondSet.add("Movies");

        Set thirdtSet = new HashSet();
        thirdtSet.add("Tennis");

        List<User> users = List.of(
                new User(1, "Gadzhi", 18, firstSet),
                new User(2, "Vlad", 30, secondSet),
                new User(3, "Ali", 22, thirdtSet)
        );

        Set<String> activities = new HashSet<>(List.of("Football", "Movies", "Tennis"));

        System.out.println(User.findHobbyLovers(users,activities));

    }
}