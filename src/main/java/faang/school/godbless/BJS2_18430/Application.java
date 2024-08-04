package faang.school.godbless.BJS2_18430;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        Set<String> activities = Set.of("Dancing", "Coding", "Bike");

        List<User> users = new ArrayList<>();

        users.add(new User(1, "Misha", 25, Set.of("Dancing","Swimming","Football")));
        users.add(new User(2, "Max", 22, Set.of("Volleyball","Singing","Darts")));
        users.add(new User(3, "Vera", 30, Set.of("Hockey","Photography", "Bike")));
        users.add(new User(4, "Sveta", 19, Set.of("Hiking", "Coding", "Dancing")));

        System.out.println(User.findHobbyLovers(users, activities));
    }
}