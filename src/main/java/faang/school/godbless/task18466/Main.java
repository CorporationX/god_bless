package faang.school.godbless.task18466;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activitis = new HashSet<>();
        activitis.add("boxing");
        activitis.add("football");
        activitis.add("tennis");
        activitis.add("ski");

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Igor", 22, Set.of("boxing", "football", "tennis")));
        users.add(new User(2, "Anna", 24, Set.of("ski")));

        System.out.println(User.findHobbyLovers(users, activitis));
        System.out.println("hello");


    }
}
