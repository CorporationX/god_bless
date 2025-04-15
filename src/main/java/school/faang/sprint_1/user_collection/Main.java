package school.faang.sprint_1.user_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> actvityKirill = new HashSet<>();
        actvityKirill.add("Football");
        actvityKirill.add("Gaming");
        actvityKirill.add("Cooking");

        Set<String> actvityVictor = new HashSet<>();
        actvityVictor.add("Reading");
        actvityVictor.add("Gaming");
        actvityVictor.add("Chess");

        Set<String> actvityDima = new HashSet<>();
        actvityDima.add("Swimming");
        actvityDima.add("Running");
        actvityDima.add("Cooking");

        Set<String> actvity = new HashSet<>();
        actvity.add("Gaming");
        actvity.add("Cooking");

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Kirill", 23, actvityKirill));
        users.add(new User(2, "Victor", 23, actvityVictor));
        users.add(new User(3, "Dima", 23, actvityDima));

        User checker = new User();
        System.out.println(checker.findHobbyLovers(users, actvity));
    }
}
