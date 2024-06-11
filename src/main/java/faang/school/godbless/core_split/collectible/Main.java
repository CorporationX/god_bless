package faang.school.godbless.core_split.collectible;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User alen = new User(0, "Alen", 1, Set.of("A","B"));
        User bob = new User(1, "Bob", 1, Set.of("H","L"));
        User ken = new User(2, "Ken", 1, Set.of("L", "p"));

        List<User> users = new ArrayList<>();

        users.add(alen);
        users.add(bob);
        users.add(ken);

        Set<String> activity = new HashSet<>();
        activity.add("A");
        activity.add("B");
        activity.add("J");
        activity.add("H");

        System.out.println(alen.findHobbyLovers(users, activity));


    }
}
